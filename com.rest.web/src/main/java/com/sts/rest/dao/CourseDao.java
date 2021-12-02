package com.sts.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.rest.model.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
