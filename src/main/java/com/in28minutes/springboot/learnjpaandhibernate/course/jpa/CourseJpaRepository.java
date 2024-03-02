package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
//here i show the concept of the jpa
//when need to run the query using the jpa need to use the annotation transactional
//basically in simple it means that any database operations performed within the marked method or class will be executed within a transaction. if the transaction is successful , the changes will commited to the database 
// if the error comes and transaction is rolled back , the changes will not be persisted in the database.
//@Transactional(propagation = Propagation.REQUIRED)  when we want every time new transaction is created
@Repository
@Transactional //whenever you have to run queries through jpa add the transactional annotation
public class CourseJpaRepository {
//	here you can use autowired or you can use Presistance
//	@Autowired
//	
	@PersistenceContext
	private EntityManager entityManager; //used to manage the entity
	
//	for performing the inseration operation in the database using the jpa
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
//	for searching in the database
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
//	for deleting in the database
	public void deleteById(long id) {
		Course course=entityManager.find(Course.class, id);
		 entityManager.remove(course);
	}
}




// difference between jpa and hibernate 
// Jpa defines the specification it is an Api
//Hiberante is one of the popular implementations of JPA 
//  we can directly used the hibernate implementation in code using hibernate annotation
//TopLink is also a JPA implementations 
//once you have a JPA implemented ,then you can use hibernate in it 