package com.parimal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.exception.StudentException;
import com.parimal.model.Course;
import com.parimal.model.Student;

@Service
public interface StudentService
{

	public List<Student> getallStudent() throws StudentException;

	public String addStudent(Student student) throws StudentException;

	public Student updateStudent(Student student) throws StudentException;

	public Student deleteStudent(Integer sId) throws StudentException;

	public List<Course> enrollCourse(String cname, Integer studentId) throws StudentException;
}
