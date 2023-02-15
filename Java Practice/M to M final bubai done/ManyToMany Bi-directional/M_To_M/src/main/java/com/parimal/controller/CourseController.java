package com.parimal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parimal.exception.CourseException;
import com.parimal.model.Course;
import com.parimal.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController
{
	@Autowired
	private CourseService cService;

	@GetMapping("/getall")
	public ResponseEntity<List<Course>> getallCourse() throws CourseException
	{
		return new ResponseEntity<List<Course>>(cService.getallCourse(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addCourse(@RequestBody Course course) throws CourseException
	{
		return new ResponseEntity<String>(cService.addCourse(course), HttpStatus.CREATED);
	}

	@PostMapping("/update")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseException
	{
		return new ResponseEntity<Course>(cService.updateCourse(course), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{cname}")
	public ResponseEntity<Course> deleteCourse(@PathVariable("cname") String cname) throws CourseException
	{
		return new ResponseEntity<Course>(cService.deleteCourse(cname), HttpStatus.ACCEPTED);
	}

}
