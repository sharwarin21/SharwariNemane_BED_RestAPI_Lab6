package com.gl.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.StudentManagementSystem.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
