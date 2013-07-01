package com.thoughtworks.sample.webapp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {

    private TodoService todoService;
    private HomeController homeController;

    @Before
    public void setUp() throws Exception {
        todoService = mock(TodoService.class);
        homeController = new HomeController();

        homeController.setTodoService(todoService);
    }

    @Test
    public void shouldRenderHomeView() {
        when(todoService.getTodos()).thenReturn(new ServiceResult<List<Todo>>(noErrors(), new ArrayList<Todo>()));

        ModelAndView modelAndView = homeController.index();

        assertThat(modelAndView.getViewName(), is("home"));
    }

    @Test
    public void shouldSetTodosForHomeView() {
        ArrayList<Todo> todos = new ArrayList<Todo>();

        when(todoService.getTodos()).thenReturn(new ServiceResult<List<Todo>>(noErrors(), todos));

        ModelAndView modelAndView = homeController.index();

        assertThat((ArrayList<Todo>) modelAndView.getModel().get("todos"), is(todos));
    }

    @Test
    public void shouldRenderErrorsViewWhenServiceReturnsErrors() {
        when(todoService.getTodos()).thenReturn(new ServiceResult<List<Todo>>(someErrors(), new ArrayList<Todo>()));

        ModelAndView modelAndView = homeController.index();

        assertThat(modelAndView.getViewName(), is("errors"));
    }

    @Test
    public void shouldSetErrorsForViewWhenServiceReturnsErrors() {
        HashMap<String, String> errors = someErrors();

        when(todoService.getTodos()).thenReturn(new ServiceResult<List<Todo>>(errors, new ArrayList<Todo>()));

        ModelAndView modelAndView = homeController.index();

        assertThat((HashMap<String, String>) modelAndView.getModel().get("errors"), is(errors));
    }

    private HashMap<String, String> someErrors() {
        HashMap<String,String> result = new HashMap<String, String>();
        result.put("an error", "with stuff");
        return result;
    }

    private HashMap<String, String> noErrors() {
        return new HashMap<String, String>();
    }
}
