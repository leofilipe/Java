package com.github.leofilipe.springboot.todo_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.leofilipe.springboot.todo_app.model.Todo;
import com.github.leofilipe.springboot.todo_app.model.TodoRepository;
import com.github.leofilipe.springboot.todo_app.service.TodoService;

import jakarta.validation.Valid;

@Controller // intermediates view requests and services' logic
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	// list-todos
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {

		String username = getLoggedUsername(model);

		List<Todo> todos = todoRepository.findByUsernameIgnoreCase(username);
		// todoService.findByUsername(username);

		model.addAttribute("todos", todos);

		return "listTodos";
	}

	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		// cria um todo padrao para este usuario
		Todo todo = new Todo(0, getLoggedUsername(model), "Default-desc", LocalDate.now().plusWeeks(1), false);
		model.put("todo", todo); // vincula o todo padrao ao modelo da pagina
		return "addTodo";
	}

	// add-todo
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}
		String loggedUsername = getLoggedUsername(model);
		todo.setUsername(loggedUsername);

		todoRepository.save(todo);

		// recupera os campos do modelo da pagina e adiciona ao novo todo
		// todoService.addTodo(loggedUsername, todo.getDescription(),
		// todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		// delete todo and redirect to todo list

		Todo todo = todoRepository.findById(id).get();

		model.addAttribute("todo", todo);

		return "addTodo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
		// delete todo and redirect to todo list

		if (result.hasErrors()) {
			return "addTodo";
		}

		String username = getLoggedUsername(model);
		todo.setUsername(username);

		todoRepository.save(todo);
		// todoService.updateTodo(todo);

		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// delete todo and redirect to todo list

		todoRepository.deleteById(id);
		// todoService.deleteTodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping("cancel-todo")
	public String cancelShowTodo() {
		return "redirect:list-todos";
	}

	private String getLoggedUsername(ModelMap model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return auth.getName();
	}
}
