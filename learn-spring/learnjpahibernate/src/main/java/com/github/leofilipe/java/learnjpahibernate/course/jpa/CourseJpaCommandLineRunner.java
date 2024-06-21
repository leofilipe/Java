package com.github.leofilipe.java.learnjpahibernate.course.jpa;

import org.springframework.boot.CommandLineRunner;

import com.github.leofilipe.java.learnjpahibernate.course.Course;

//@Component //removido para dar preferencia a CourseSpringDataCommandLineRunner 
public class CourseJpaCommandLineRunner implements CommandLineRunner {

	// @Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn AWS Now!", "leofilipe"));
		repository.insert(new Course(2, "Learn Golang Now!", "leofilipe"));
		repository.insert(new Course(3, "Learn DevOps Now!", "leofilipe"));

		repository.deleteById(1);

		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
	}

}
