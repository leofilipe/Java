package com.github.leofilipe.springboot.todo_app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.leofilipe.springboot.todo_app.model.Todo;
import com.github.leofilipe.springboot.todo_app.service.TodoService;

@Controller
public class TodoController {

	private  TodoService todoService;
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}



	// list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		List<Todo> todos = todoService.findByUsername("leo");
		
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}
}
