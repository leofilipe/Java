package com.github.leofilipe.springboot.todo_app.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

	public List<Todo> findByUsername(String username);
	public List<Todo> findByUsernameIgnoreCase(String username);
}
