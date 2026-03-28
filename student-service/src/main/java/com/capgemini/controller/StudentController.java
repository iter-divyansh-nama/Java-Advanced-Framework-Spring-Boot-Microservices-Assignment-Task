package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.dto.StudentResponse;
import com.capgemini.model.entity.Student;
import com.capgemini.model.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@PostMapping("/students/bulk")
	public List<Student> saveStudents(@RequestBody List<Student> students) {
		return studentService.saveStudents(students);
	}
	
	@GetMapping("/student/{id}")
	public StudentResponse getStudentWithProject(@PathVariable Integer id) {
		return studentService.getStudentWithProject(id);
	}
}