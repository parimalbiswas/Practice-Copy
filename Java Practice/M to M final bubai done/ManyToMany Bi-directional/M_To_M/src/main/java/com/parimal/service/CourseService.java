package com.parimal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parimal.exception.CourseException;
import com.parimal.model.Course;

@Service
public interface CourseService
{

	public List<Course> getallCourse() throws CourseException;

	public String addCourse(Course course) throws CourseException;

	public Course updateCourse(Course course) throws CourseException;

	public Course deleteCourse(String cname) throws CourseException;

}
