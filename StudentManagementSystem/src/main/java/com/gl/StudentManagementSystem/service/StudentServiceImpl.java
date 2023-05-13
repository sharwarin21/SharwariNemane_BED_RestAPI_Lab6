package com.gl.StudentManagementSystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.StudentManagementSystem.entity.Student;
import com.gl.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	@Transactional
	public List<Student> findAll() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student findByStudentId(Integer studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteByStudentId(Integer studentId) {
		studentRepository.deleteById(studentId);
	}

}
