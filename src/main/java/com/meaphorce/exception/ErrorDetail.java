package com.meaphorce.exception;

public class ErrorDetail {
    private String message;
    private String fieldName;
    private String type;

    public ErrorDetail(String message, String fieldName, String type) {
        this.message = message;
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
