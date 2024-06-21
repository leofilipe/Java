package com.github.leofilipe.java.learnjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.github.leofilipe.java.learnjpahibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext // tb poderia ser Autowired, mas esta eh uma opcao melhor
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		
		Course c = entityManager.find(Course.class, id);
		entityManager.remove(c);
		
	}

}
