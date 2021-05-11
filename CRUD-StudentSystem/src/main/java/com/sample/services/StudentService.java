package com.sample.services;

import java.util.List;

import com.sample.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	public void saveStudent(Student student);
	Student getStudentById(long id);
	public void deleteStudentById(long id);
}
