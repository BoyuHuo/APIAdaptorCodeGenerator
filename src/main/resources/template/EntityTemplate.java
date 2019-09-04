package com.peware.o2o.common.model.dataSync;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A java bean class for google drive and gs2 data sync
 *
 * @author ${author}
 * @version 1.0.0
 * Created on Aug 28, 2019
 * Last modified on Aug 28, 2019
 * Last modified by none
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ${bean_name}Bean {
    <#list attribute as att>
        @JsonProperty("${att.jsonField}")
        private ${att.type} ${att.javaField};
    </#list>

    <#list attribute as att>

    public ${att.type} get${att.javaField}() {
        return ${att.javaField};
    }
    public void set${att.javaField}(${att.type} ${att.javaField}) {
        this.${att.javaField} = ${att.javaField};
    }

    </#list>

}
