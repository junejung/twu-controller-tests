package com.thoughtworks.sample.webapp;

import java.util.HashMap;

public class SlowService {
    public ServiceResult<SlowResult> doSomethingSlow() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        return new ServiceResult<SlowResult>(new HashMap<String, String>(), new SlowResult("SUCCESS"));
    }
}
