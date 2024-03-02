package com.MobileSystem.util;

public class SQLResult {
    private Boolean status;
    private String message;
    private Object target;

    public SQLResult(Boolean status) {
        this.status = status;
    }

    public SQLResult(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public SQLResult(Boolean status, String message, Object target) {
        this.status = status;
        this.message = message;
        this.target = target;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getTarget() {
        return target;
    }
}
