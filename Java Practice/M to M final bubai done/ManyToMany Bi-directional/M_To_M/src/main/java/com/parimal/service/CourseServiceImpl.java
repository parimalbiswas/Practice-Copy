package com.parimal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.CourseException;
import com.parimal.model.Course;
import com.parimal.model.Student;
import com.parimal.repository.CourseDao;
import com.parimal.repository.StudentDao;

@Service
public class CourseServiceImpl implements CourseService
{
	@Autowired
	private CourseDao cDao;

	@Autowired
	private StudentDao sDao;

	@Override
	public List<Course> getallCourse() throws CourseException
	{
		return cDao.findAll();

	}

	@Override
	public String addCourse(Course course) throws CourseException
	{
		Course registerCourse = cDao.save(course);

		return registerCourse.getCName() + " is Registed Sussfully........";

	}

	@Override
	public Course updateCourse(Course course) throws CourseException
	{
		Course existCourse = cDao.findById(course.getCId()).orElseThrow(() -> new CourseException("Course Not Found"));

		existCourse.setCName(course.getCName());
		existCourse.setCFee(course.getCFee());

		return cDao.save(existCourse);
	}

	@Override
	public Course deleteCourse(String cname) throws CourseException
	{

		Course course = cDao.findBycName(cname).get(0);

		if (course == null)
		{
			throw new CourseException("Course Not FOund ");
		}

		List<Student> allStudents = sDao.findAll();
		allStudents = allStudents.stream().filter(s -> s.getCourses().removeIf(c -> c.getCId() == course.getCId()))
				.collect(Collectors.toList());

		cDao.deleteById(course.getCId());

		sDao.saveAll(allStudents);

		return course;
	}

}
