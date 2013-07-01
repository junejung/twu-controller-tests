package com.thoughtworks.sample.webapp;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class TodoService {
    public ServiceResult<List<Todo>> getTodos() {
        ArrayList<Todo> todos = new ArrayList<Todo>();
        if(Math.random() * 10 < 5) {
            todos.add(new Todo("A random todo"));
        }
        return new ServiceResult<List<Todo>>(new HashMap<String, String>(), todos);
    }
}
