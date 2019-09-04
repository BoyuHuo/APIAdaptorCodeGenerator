package model;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Generator {
    private FileInfo entityData;
    private FileInfo serviceData;
    private FileInfo controllerData;

    public FileInfo getEntityData() {
        return entityData;
    }

    public void setEntityData(FileInfo entityData) {
        this.entityData = entityData;
    }

    public FileInfo getServiceData() {
        return serviceData;
    }

    public void setServiceData(FileInfo serviceData) {
        this.serviceData = serviceData;
    }

    public FileInfo getControllerData() {
        return controllerData;
    }

    public void setControllerData(FileInfo controllerData) {
        this.controllerData = controllerData;
    }
}
