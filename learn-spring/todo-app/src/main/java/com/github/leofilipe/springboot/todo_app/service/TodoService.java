package com.github.leofilipe.springboot.todo_app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.leofilipe.springboot.todo_app.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();

	static {
		todos.add(new Todo(1, "Leo", "Learn Spring", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(1, "Leo", "Learn AWS", LocalDate.now().plusMonths(10), false));
		todos.add(new Todo(1, "Leo", "Learn DevOps", LocalDate.now().plusMonths(16), false));
	}

	public List<Todo> findByUsername(String username) {

		return todos;
	}
}
