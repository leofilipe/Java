package com.github.leofilipe.springboot.todo_app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.github.leofilipe.springboot.todo_app.model.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();

	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "Leo", "Learn Spring S", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(++todosCount, "Leo", "Learn AWS S", LocalDate.now().plusMonths(10), false));
		todos.add(new Todo(++todosCount, "Leo", "Learn DevOps S", LocalDate.now().plusMonths(16), false));
	}

	public List<Todo> findByUsername(String username) {

		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public Todo findById(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();

		return todo;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {

		Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
		todos.add(todo);
	}

	public void deleteTodo(int id) {

		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub

		Predicate<? super Todo> predicate = aTodo -> aTodo.getId() == todo.getId();
		Todo aTodo = todos.stream().filter(predicate).findFirst().get();

		aTodo.setDescription(todo.getDescription());
		aTodo.setTargetDate(todo.getTargetDate());

	}
}
