package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.StudentException;
import com.parimal.model.Course;
import com.parimal.model.Student;
import com.parimal.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController
{
	@Autowired
	private StudentService sService;

	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getallCourse() throws StudentException
	{
		return new ResponseEntity<List<Student>>(sService.getallStudent(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCourse(@RequestBody Student student) throws StudentException
	{
		return new ResponseEntity<String>(sService.addStudent(student), HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateCourse(@RequestBody Student student) throws StudentException
	{
		return new ResponseEntity<Student>(sService.updateStudent(student), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<Student> deleteCourse(@PathVariable("sid") Integer sId) throws StudentException
	{
		return new ResponseEntity<Student>(sService.deleteStudent(sId), HttpStatus.ACCEPTED);
	}

	@PostMapping("/update/{coursename}/{studentid}")
	public ResponseEntity<List<Course>> enrollToCourse(@PathVariable("coursename") String coursename,
			@PathVariable("studentid") Integer studentId) throws StudentException
	{
		return new ResponseEntity<List<Course>>(sService.enrollCourse(coursename, studentId), HttpStatus.ACCEPTED);
	}
	// enrollCourse

}
