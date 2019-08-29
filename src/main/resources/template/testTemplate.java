package com.test.entity;

public class ${class_name} {

    private ${type} ${name};

    public ${type} get${name?cap_first}() {
        return ${name};
    }

    public void set${name?cap_first}(${type} ${name}) {
        this.${name} = ${name};
    }
}