package com.thoughtworks.sample.webapp;

public class SlowResult {
    private String status;

    public SlowResult(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
