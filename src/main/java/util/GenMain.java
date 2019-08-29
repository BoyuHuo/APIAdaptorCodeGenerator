package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Attribute;


public class GenMain {

    public static void main(String[] args) throws IOException {
        // 参数值
        Map<String, Object> map = new HashMap<String, Object>();
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(new Attribute("testName1","test_name_1","String"));
        attributes.add(new Attribute("testName2","test_name_2", "String"));
        attributes.add(new Attribute("testName3","test_name_3","int"));
        map.put("attribute", attributes);
        map.put("bean_name","Test");
        map.put("class_name","TestBean");
        map.put("author","Baiyu");

        // 模板目录
        String templateDirectory = "src/main/resources/template";
        // 模板名称
        String templateFile = "EntityTemplate.java";
        // 模板生成后存放目录
        String targetPath = "src/main/java/entity";
        // 模板生成后新文件名
        String fileName = "TestBean.java";
        // 创建文件夹
        new File(targetPath).mkdirs();
        File nFile = new File(targetPath + "/" + fileName);
        if (nFile.exists()) {
            throw new RuntimeException("File \'" + fileName + "\' already exists");
        }

        // 生成目标文件
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);

            Template template = getConfiguration(templateDirectory).getTemplate(templateFile, "UTF-8");
            template.process(map, writer);

        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }

    private static Configuration getConfiguration(String templateDirectory) {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configuration;
    }
}
