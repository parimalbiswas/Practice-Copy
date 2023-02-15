package com.parimal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parimal.exception.StudentException;
import com.parimal.model.Course;
import com.parimal.model.Student;
import com.parimal.repository.CourseDao;
import com.parimal.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	private StudentDao sDao;

	@Autowired
	private CourseDao cDao;

	@Override
	public List<Student> getallStudent() throws StudentException
	{
		return sDao.findAll();

	}

	@Override
	public String addStudent(Student student) throws StudentException
	{
//		List<Student> alreadyStudent = sDao.findAll().stream().filter(s -> s.getSName().equals(student.getSName()))
//				.collect(Collectors.toList());

		return sDao.save(student).getSName() + " Added Sussfully....";

	}

	@Override
	public Student updateStudent(Student student) throws StudentException
	{
		Student registerdstudent = sDao.findById(student.getSId())
				.orElseThrow(() -> new StudentException("Student not found..."));

		registerdstudent.setSName(student.getSName());
		registerdstudent.setSPassword(student.getSPassword());

		return sDao.save(registerdstudent);
	}

	@Override
	public Student deleteStudent(Integer sId) throws StudentException
	{
		Student student = sDao.findById(sId).orElseThrow(() -> new StudentException("Student not found..."));

		sDao.delete(student);

		return student;
	}

	@Override
	public List<Course> enrollCourse(String cname, Integer studentId) throws StudentException
	{
		// TODO Auto-generated method stub
		List<Course> courses = cDao.findBycName(cname);

		Student student = sDao.findById(studentId).orElseThrow(() -> new StudentException("Not found"));
		student.getCourses().add(courses.get(0));
		sDao.save(student);
		return student.getCourses();
	}

}
