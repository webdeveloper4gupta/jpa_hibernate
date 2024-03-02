package com.in28minutes.springboot.learnjpaandhibernate.course;
//here i make the basic structure of the table that we want to create in the database
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// here i map directly with the database table 
@Entity(name="Course")
public class Course {
	
	@Id
   private long id;
	@Column(name="name")
   private String name;
	@Column(name="author")
   private String author;
   
//   default construrctor
   public Course() {
	   
   }
//   parameterised constructor for the autowiring concept
public Course(long id, String name, String author) {
	super();
	this.id = id;
	this.name = name;
	this.author = author;
}

//here i made the getters 
public long getId() {
	return id;
}





public String getName() {
	return name;
}





public String getAuthor() {
	return author;
}





public void setId(long id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public String toString() {
	return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
}
   
//   constrructor
//   getters 
//   toString
     
}
