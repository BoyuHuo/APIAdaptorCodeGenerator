package service.imp;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import model.Attribute;
import model.EntityInfo;
import model.FileInfo;
import model.ServiceInfo;
import service.GeneratorService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratorServiceImp implements GeneratorService {

    public void generateBeanFile(EntityInfo entityInfo) throws IOException {

        // 创建文件夹
        new File(entityInfo.getTargetPath()).mkdirs();
        File nFile = new File(entityInfo.getTargetPath() + "/" + entityInfo.getTargetFileName());
        if (nFile.exists()) {
            throw new RuntimeException("File \'" + entityInfo.getTargetFileName() + "\' already exists");
        }

        // 生成目标文件
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);

            Template template = getConfiguration(entityInfo.getTemplateDirectory()).getTemplate(entityInfo.getTemplateFileName(), "UTF-8");
            template.process(entityInfo.getFieldSet(), writer);

        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
    }

    public void generateServiceFile(ServiceInfo serviceInfo) throws IOException {

        // 创建文件夹
        new File(serviceInfo.getTargetPath()).mkdirs();
        File nFile = new File(serviceInfo.getTargetPath() + "/" + serviceInfo.getTargetFileName());
        if (nFile.exists()) {
            throw new RuntimeException("File \'" + serviceInfo.getTargetFileName() + "\' already exists");
        }

        // 生成目标文件
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);

            Template template = getConfiguration(serviceInfo.getTemplateDirectory()).getTemplate(serviceInfo.getTemplateFileName(), "UTF-8");
            template.process(serviceInfo.getDataSet(), writer);

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
