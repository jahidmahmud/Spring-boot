package com.sts.rest.service;

import java.util.List;

import com.sts.rest.model.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long id);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void delete(long id);
}
