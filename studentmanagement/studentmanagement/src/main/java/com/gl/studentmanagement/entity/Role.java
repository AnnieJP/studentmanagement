package com.gl.studentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="roles")
//@Data
public class Role {
	
	@Id
	@Column(name="roles_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role;
	
	@Column(name="name")
	private String name;
	
	public Role() {
		
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", name=" + name + "]";
	}

	public Role(String name) {
		super();
		
		this.name = name;
	}
	
	
	

		
}
