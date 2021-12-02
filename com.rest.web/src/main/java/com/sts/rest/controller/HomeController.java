package com.sts.rest.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;
import com.sts.rest.model.Course;
import com.sts.rest.service.CourseService;

@RestController
public class HomeController {
	@Autowired
	private CourseService service;
	@GetMapping(path = "/home")
	public String home() {
		return "from home page";
	}
	@GetMapping(path = "/courses")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = service.getCourses();
		if(courses==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(courses);
	}
	@GetMapping(path = "/courses/{id}")
	public ResponseEntity<Course> getSingleCourse(@PathVariable("id") String id) {
		Course course = service.getCourse(Long.parseLong(id));
		if(course==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(course));
	}
	@PostMapping(path = "/courses",consumes ="application/json")
	public ResponseEntity<Course> addCourses(@RequestBody Course course) {
		Course course2=null;
		try {
			course2 = service.addCourse(course);
			return ResponseEntity.ok().body(course2);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping(path = "/courses",consumes ="application/json")
	public ResponseEntity<Course> updateCourses(@RequestBody Course course) {
		try {
			Course updateCourse = service.updateCourse(course);
			return ResponseEntity.ok().body(updateCourse);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping(path = "/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id){
		try {
			this.service.delete(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
