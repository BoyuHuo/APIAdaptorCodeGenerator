import model.Attribute;
import model.FileInfo;
import service.GeneratorService;
import service.imp.GeneratorServiceImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(new Attribute("testName1", "test_name_1", "String"));
        attributes.add(new Attribute("testName2", "test_name_2", "String"));
        attributes.add(new Attribute("testName3", "test_name_3", "int"));
        map.put("attribute", attributes);
        map.put("bean_name", "Test");
        map.put("class_name", "TestBean");
        map.put("author", "Baiyu");

        // 模板目录
        String templateDirectory = "src/main/resources/template";
        // 模板名称
        String templateFile = "EntityTemplate.java";
        // 模板生成后存放目录
        String targetPath = "src/main/java/testEntity";
        // 模板生成后新文件名
        String fileName = "TestBean.java";

        FileInfo fileInfo = new FileInfo();
        fileInfo.setDataSet(map);
        fileInfo.setTemplateDirectory(templateDirectory);
        fileInfo.setTemplateFileName(templateFile);
        fileInfo.setTargetFileName(fileName);
        fileInfo.setTargetPath(targetPath);


        GeneratorService generatorService = new GeneratorServiceImp();

        generatorService.generateBeanFile(fileInfo);

    }

}
