package com.sts.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.rest.dao.CourseDao;
import com.sts.rest.model.Course;
@Service
public class CourseServiceImpl implements CourseService {
	 //List<Course> list;
	@Autowired
	private CourseDao courseDao;
	 
	public CourseServiceImpl() {
		super();
//		list=new ArrayList<>();
//		list.add(new Course(1,"Jackson","this is good"));
//		list.add(new Course(2,"Jackson2","this is good2"));
	}

	@Override
	public List<Course> getCourses() {
		//return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long id) {
		//return list.stream().filter(i->i.getId()==id).findFirst().get();
		
		return courseDao.getById(id);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
//		return course;
		Course c = courseDao.save(course);
		return c;
	}

	@Override
	public Course updateCourse(Course course) {
//		Course course2 = list.set((int) (long)(course.getId())-1, course);
//		return course2;
		Course c = courseDao.save(course);
		return c;
	}

	@Override
	public void delete(long id) {
//		Course course = this.getCourse(id);
//		list.remove(course);
		courseDao.delete(getCourse(id));
		
	}

}
