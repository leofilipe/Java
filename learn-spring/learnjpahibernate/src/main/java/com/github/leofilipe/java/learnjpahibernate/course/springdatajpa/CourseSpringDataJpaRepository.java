package com.github.leofilipe.java.learnjpahibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.leofilipe.java.learnjpahibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	public List<Course> findByAuthor(String author);
	public List<Course> findByName(String name);
}
