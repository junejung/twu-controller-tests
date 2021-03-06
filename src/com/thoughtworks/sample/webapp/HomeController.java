package com.thoughtworks.sample.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ServiceResult<List<Todo>> result = todoService.getTodos();

        if(result.hasErrors()) {
            return new ModelAndView("errors", "errors", result.getErrors());
        }

        return new ModelAndView("home", "todos", result.getResult());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView create(HttpServletRequest request) {
        Todo todo = new Todo(request.getParameter("description"));
        ServiceResult<List<Todo>> result = todoService.createTodo(todo);

        if(result.hasErrors()) {
            return new ModelAndView("errors", "errors", result.getErrors());
        }

        return new ModelAndView("home", "todos", result.getResult());
    }

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }
}
