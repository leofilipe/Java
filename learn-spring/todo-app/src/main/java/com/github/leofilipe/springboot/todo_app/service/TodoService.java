package com.github.leofilipe.springboot.todo_app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.leofilipe.springboot.todo_app.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();

	private static int todosCount = 0;

	static {
		todos.add(new Todo(++todosCount, "Leo", "Learn Spring", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(++todosCount, "Leo", "Learn AWS", LocalDate.now().plusMonths(10), false));
		todos.add(new Todo(++todosCount, "Leo", "Learn DevOps", LocalDate.now().plusMonths(16), false));
	}

	public List<Todo> findByUsername(String username) {

		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {

		Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
		todos.add(todo);
	}
}
