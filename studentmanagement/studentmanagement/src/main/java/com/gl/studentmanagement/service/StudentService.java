package com.gl.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.studentmanagement.entity.Student;


public interface StudentService {
	
	public void save(Student theStudent);
	
	public void deleteById(int theId);
	
	public List<Student> findAll();
	
	public  Student findById(int theId);
	

}
