package com.github.leofilipe.java.learnjpahibernate.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.leofilipe.java.learnjpahibernate.course.Course;

@Component
public class CourseSpringDataCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Learn AWS Now Again!", "leofilipe"));
		repository.save(new Course(2, "Learn Golang Now Again!", "leofilipe"));
		repository.save(new Course(3, "Learn DevOps Now Again!", "leofilipe"));

		repository.deleteById(1l);

		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println("Find all: " + repository.findAll());
		System.out.println("Find by author: " + repository.findByAuthor("leofilipe"));
		System.out.println("Find by author: " + repository.findByAuthor(""));
		System.out.println("Find by course name: " + repository.findByName("Learn Golang Now Again!"));
	}

}
