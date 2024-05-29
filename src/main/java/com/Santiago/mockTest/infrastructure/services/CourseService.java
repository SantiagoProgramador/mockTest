package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.CourseRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.repositories.CourseRepository;
import com.Santiago.mockTest.infrastructure.abstracts.ICourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

  @Autowired
  private final CourseRepository courseRepository;

  @Override
  public CourseResponse create(CourseRequest request) {
    Course course = new Course();
    BeanUtils.copyProperties(request, course);

    return this.courseToCourseResponse(this.courseRepository.save(course));
  }

  @Override
  public CourseResponse update(CourseRequest request, Long id) {
    Course course = this.findCourse(id);
    this.courseRequestToCourse(request, course);

    return this.courseToCourseResponse(this.courseRepository.save(course));
  }

  @Override
  public boolean delete(Long id) {
    Course course = this.findCourse(id);
    this.courseRepository.delete(course);

    return true;
  }

  @Override
  public CourseResponse findById(Long id) {
    Course course = this.findCourse(id);

    return this.courseToCourseResponse(course);
  }

  private Course findCourse(Long id) {
    return this.courseRepository.findById(id).orElseThrow();
  }

  @Override
  public List<CourseResponse> getAll() {

    return this.courseRepository.findAll().stream().map(this::courseToCourseResponse).toList();
  }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();
    BeanUtils.copyProperties(course, courseResponse);

    return courseResponse;
  }

  private Course courseRequestToCourse(CourseRequest courseRequest, Course course) {
    BeanUtils.copyProperties(courseRequest, course);

    return course;
  }
}
