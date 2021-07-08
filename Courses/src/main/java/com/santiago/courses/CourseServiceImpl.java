package com.santiago.courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;


import com.santiago.courses.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	
	Map<Long, Course> courses = new HashMap<>();
	long currentId = 1;
	
	public CourseServiceImpl() {
		init();
	}
	
	void init() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("Matematica");
		course.setTaughtBy("Horacio");
		course.setRating(5);
		courses.put(course.getId(), course);
		System.out.println(course.toString());	
	}

	

	@Override
	public List<Course> getCourses() {
		Collection<Course> results = courses.values();
		List<Course> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Course getCourse(Long id) {
		if(courses.get(id) == null) {
			throw new NotFoundException();
		}
		return courses.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		course.setId(++currentId);
		courses.put(course.getId(), course);
		courses.put(course.getId(), course);
		return Response.ok(course).build();
	}

	@Override
	public Response updateCourse(Course course) {
		
		Course currentCourse = courses.get(course.getId());
		
		Response response;
		if(currentCourse != null) {
			courses.put(course.getId(), course);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Response deletePatient(Long id) {
		Course course = courses.get(id);
		
		Response response;
		
		if (course != null) {
			courses.remove(id);
			response = Response.ok().build();
		}else {
			response = Response.notModified().build();
		}
		
		return response;
	}
	
	
	

}
