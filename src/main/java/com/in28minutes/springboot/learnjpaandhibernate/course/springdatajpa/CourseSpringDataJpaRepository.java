package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
//general syntax extends JpaRepository<Enity that manage,id field type>
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {
//   here i make the custom method 
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
