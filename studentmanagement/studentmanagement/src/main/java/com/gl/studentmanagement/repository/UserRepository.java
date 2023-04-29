package com.gl.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentmanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByUsername(String username);

}
