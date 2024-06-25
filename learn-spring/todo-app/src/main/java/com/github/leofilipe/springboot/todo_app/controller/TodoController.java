package com.github.leofilipe.springboot.todo_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.leofilipe.springboot.todo_app.model.Todo;
import com.github.leofilipe.springboot.todo_app.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

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

	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		//cria um todo padrao para este usuario
		Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusWeeks(1), false);
		model.put("todo", todo); //vincula o todo padrao ao modelo da pagina
		return "addTodo";
	}

	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, Todo todo) {

		//recupera os campos do modelo da pagina e adiciona ao novo todo
		todoService.addTodo((String) model.get("name"), todo.getDescription(), LocalDate.now().plusWeeks(1), false);
		return "redirect:list-todos";
	}
}
