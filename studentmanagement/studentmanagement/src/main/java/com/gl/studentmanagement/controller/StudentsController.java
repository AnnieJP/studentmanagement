package com.gl.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gl.studentmanagement.entity.Student;
import com.gl.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/listStudents")
	public String listStudents(Model theModel) {
		
		List<Student> theStudents = studentService.findAll();
		
		theModel.addAttribute("Students", theStudents);
		
		return "list-Students";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student student = new Student();
		
		theModel.addAttribute("student", student);
		
		return "Student-form";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		 
		Student student = studentService.findById(theId);
		
		theModel.addAttribute("student", student);
		
		return "Student-Form";
		
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id, Model theModel) {
		
		studentService.deleteById(id);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("course") String course, @RequestParam("country") String country) {
		
		Student theStudent;
		if(id!=0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);			
		}
		else {
			theStudent = new Student(firstName, lastName, course, country);
		}
		
		studentService.save(theStudent);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
	
	

}
