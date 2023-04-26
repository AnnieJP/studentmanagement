package com.gl.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentmanagement.entity.Student;


public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
