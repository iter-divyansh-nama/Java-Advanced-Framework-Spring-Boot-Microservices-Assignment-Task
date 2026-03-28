package com.capgemini.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.model.dto.Project;
import com.capgemini.model.dto.StudentResponse;
import com.capgemini.model.entity.Student;
import com.capgemini.model.feignclient.ProjectFeignClient;
import com.capgemini.model.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ProjectFeignClient projectFeignClient;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> saveStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}
	
	public StudentResponse getStudentWithProject(Integer id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found"));
		Project project = projectFeignClient.getProjectById(student.getProjectId());
		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setId(student.getId());
		studentResponse.setName(student.getName());
		studentResponse.setMailId(student.getMailId());
		studentResponse.setContactNumber(student.getContactNumber());
		studentResponse.setProject(project);
		return studentResponse;
	}
}