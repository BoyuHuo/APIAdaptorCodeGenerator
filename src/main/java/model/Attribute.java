package model;

public class Attribute {
    private String type;
    private String javaField;
    private String jsonField;

    public Attribute(String javaField,String jsonField,String type){
        this.javaField = javaField;
        this.jsonField = jsonField;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    public String getJsonField() {
        return jsonField;
    }

    public void setJsonField(String jsonField) {
        this.jsonField = jsonField;
    }
}
