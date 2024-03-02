package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
// way of running the queries by itself
//this  is way of inserting data using spring jdbc
@Repository //used to maike this class talk with the database
public class CourseJdbcRepository {
//	Use to write in database
	@Autowired
    private	JdbcTemplate springJdbcTemplate;
    
    private static String INSERT_QUERY=""" 
    		insert into course(id,name,author)values(?,?,?);
    		""";
    private static String DELETE_QUERY=""" 
    		delete from course where id=?
    		""";
    private static String SELECT_QUERY=""" 
    	select * from course where id=?
    		""";
//    here i do the bean autowiring usiing the paramtererised
    public void insert(Course course) {
    	springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }
    public void deleteById(long id) {
    	springJdbcTemplate.update(DELETE_QUERY,id);
    }
  public Course findById(long id) {
//	  general syntax queryForObject(Select_query,resultset--->map>>(Course.class)to bean,id); //used for queryspecific bean 
	 return  springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);//2nd parameter is resultSet that we need tosetup to the bean 
//	  ResultSet  --->Bean =>Row Mapper =>
//	  id //3rd parameter
	  
  }
}
