package com.gl.StudentManagementSystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.StudentManagementSystem.entity.Student;
import com.gl.StudentManagementSystem.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String getStudents(Model model) {
		List<Student> studentList = studentService.findAll();
		model.addAttribute("Students", studentList);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAddingStudents(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdatingStudents(@RequestParam("studentId") Integer studentId, Model model) {
		Student student = studentService.findByStudentId(studentId);
		model.addAttribute("Student", student);
		return "student-form";
	}

	@RequestMapping("/save")
	public String saveStudent(@RequestParam("studentId") Integer studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student;
		if (studentId != 0) {
			student = studentService.findByStudentId(studentId);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(firstName, lastName, course, country);
		}
		studentService.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") Integer studentId) {
		studentService.deleteByStudentId(studentId);
		return "redirect:/student/list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView mv = new ModelAndView();
		if (user != null)
			mv.addObject("msg", "Hello " + user.getName() + ", you do not have permission to access this page!");
		else
			mv.addObject("msg", "You do not have permission to access this page!");
		mv.setViewName("403");
		return mv;
	}
}
