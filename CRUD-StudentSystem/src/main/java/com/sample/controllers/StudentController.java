package com.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.model.Student;
import com.sample.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("listStudents", studentService.getAllStudents());
		return "index";
	}
	@RequestMapping("/newStudentForm")
	public String newStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "newStudent";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		return "redirect:/";
		
	}
	@GetMapping("/showStudentForUpdate/{id}")
	public String showStudentForUpdate(@PathVariable(value="id") long id,Model model) {
		//get student from service
		Student student = studentService.getStudentById(id);
		
		//set student  as a model attribute
		model.addAttribute("student", student);
		return "updateStudent";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value="id") long id) {
		//delete method
		this.studentService.deleteStudentById(id);
		return "redirect:/";
	}
}
