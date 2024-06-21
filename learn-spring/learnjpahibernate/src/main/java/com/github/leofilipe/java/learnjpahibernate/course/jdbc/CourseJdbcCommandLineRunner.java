package com.github.leofilipe.java.learnjpahibernate.course.jdbc;

import org.springframework.boot.CommandLineRunner;

import com.github.leofilipe.java.learnjpahibernate.course.Course;

//@Component //removido para dar preferencia a CourseJpaCommandLineRunner 
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	// @Autowired
	private CourseJdbcRepository repository;

	//@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn AWS Now!", "leofilipe"));
		repository.insert(new Course(2, "Learn Pyton Now!", "leofilipe"));
		repository.insert(new Course(3, "Learn DevOps Now!", "leofilipe"));

		repository.delete(1);

		System.out.println(repository.selectById(2));
		System.out.println(repository.selectById(3));
	}

}
