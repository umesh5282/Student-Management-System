package com.umesh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.umesh.entity.Student;
import com.umesh.service.StudentService;

@Controller
public class StudentControler {


	private StudentService studentservice;

	public StudentControler(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}



	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		
		return "students";
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student obj to hold student from data
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	@PostMapping("/students")
	public String svaeStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id, Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		
		return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id ,@ModelAttribute ("student")  Student student, Model model) {
		
		// get student from data base by id
		Student exitingStudent =studentservice.getStudentById(id);
		exitingStudent.setId(id);
		exitingStudent.setFirstName(student.getFirstName());
		exitingStudent.setLastName(student.getLastName());
		exitingStudent.setEmail(student.getEmail());
		
		// save update student object 
		studentservice.updateStudent(exitingStudent);
		return "redirect:/students";
		
	}
	
	// handler method to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentservice.deleteStudentById(id);
		
		return "redirect:/students";
		
		
	}
}
