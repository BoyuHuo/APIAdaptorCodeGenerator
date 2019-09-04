package template


/**
 * ${desc}
 *
 * @param ${bean_name}       ${bean_name}.
<#if authentication> * @param auth       auth </#if>
 * @return
 */
public Object syncData(${bean_name} ${bean_name?uncap_first}<#if authentication> ,Authentication auth </#if) {


    <#if authentication>
    String userToken =
    ((SimpleKeycloakAccount) auth.getDetails())
            .getKeycloakSecurityContext().getTokenString();

    body.setUserToken(userToken);
    </#if>

    HttpHeaders headers = userService.getAdminHeaders();

    HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);
    log.info("url:" + url);
    log.info("header:" + headers);
    log.info("requestBody:" + requestEntity);

    ResponseEntity<Object> exchange =
    restTemplate.exchange(${targetUrl},
            HttpMethod.${targetMethod}, requestEntity, Object.class);
    return exchange.getBody();
}