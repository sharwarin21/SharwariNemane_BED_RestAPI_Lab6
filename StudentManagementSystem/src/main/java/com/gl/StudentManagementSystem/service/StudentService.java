package com.gl.StudentManagementSystem.service;

import java.util.List;

import com.gl.StudentManagementSystem.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findByStudentId(Integer studentId);

	public void save(Student student);

	public void deleteByStudentId(Integer studentId);

}
