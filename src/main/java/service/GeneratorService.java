package service;

import model.FileInfo;

import java.io.IOException;

public interface GeneratorService {
    void generateBeanFile(FileInfo fileInfo) throws IOException;
    void generateServiceFile(FileInfo fileInfo) throws IOException;
}
