package com.umesh.service;

import java.util.List;


import com.umesh.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent (Student student);
	
	Student getStudentById(long id);
	Student updateStudent (Student student);
	
	void deleteStudentById(long id);
}
