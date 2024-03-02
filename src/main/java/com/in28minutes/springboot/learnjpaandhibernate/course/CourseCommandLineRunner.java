package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;






//CommndLineRunner interface implements to run the queries when it will start running

//to  run queries at immmediate running of the application

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	
	@Autowired 
	private CourseSpringDataJpaRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
		
//	for springjdbc 
//		 repository.insert()
//		here i fire the query  --->used in the jdbc ,sppringjdbc, jpa
//		repository.insert(new Course(1,"Learn AWS Jpa!","in28minutes"));
//		repository.insert(new Course(2,"Learn Azure Jpa!","in28minutes"));
//		repository.insert(new Course(3,"Learn DevOps Jpa!","in28minutes"));
//		
//		
//		repository.deleteById(1);
//		System.out.println(repository.findById(2));
//		System.out.println(repository.findById(3));
		
		
//		here i write the query for the springdatajpa
		repository.save(new Course(1,"Learn AWS Jpa!","in28minutes"));
		repository.save(new Course(2,"Learn Azure Jpa!","in28minutes"));
		repository.save(new Course(3,"Learn DevOps Jpa!","in28minutes"));
		
//		here id use the longdatatype that why i write repository.deleteById(digit(l));
		repository.deleteById(1l);
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
//		find all the courses
		
		repository.findAll(); // to find all the entities
	System.out.println(repository.count()); // how many entities are present
//		here i call the manual method 
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn AWS Jpa!"));
	}

}
