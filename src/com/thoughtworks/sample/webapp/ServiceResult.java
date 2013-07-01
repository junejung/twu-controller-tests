package com.thoughtworks.sample.webapp;

import java.util.HashMap;

public class ServiceResult<T> {
    private HashMap<String, String> errors;
    private T result;

    public ServiceResult(HashMap<String, String> errors, T result) {
        this.errors = errors;
        this.result = result;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public T getResult() {
        return result;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
