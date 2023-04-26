package com.gl.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.gl.studentmanagement.controller","com.gl.studentmanagement.entity","com.gl.studentmanagement.repository","com.gl.studentmanagement.service"})
public class StudentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

}
