package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.CourseRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentToCourse;
import com.Santiago.mockTest.api.Dto.Response.MessageToCourse;
import com.Santiago.mockTest.infrastructure.abstracts.ICourseService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {

  @Autowired
  private final ICourseService iCourseService;

  @GetMapping(path = "/all")
  public ResponseEntity<List<CourseResponse>> showAll() {

    return ResponseEntity.ok(this.iCourseService.getAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CourseResponse> showCourse(@PathVariable Long id) {

    return ResponseEntity.ok(this.iCourseService.findById(id));
  }

  @GetMapping(path = "/{id}/messages")
  public ResponseEntity<List<MessageToCourse>> showMessagesInCourse(@PathVariable Long id) {

    return ResponseEntity.ok(this.iCourseService.getMessagesInCourse(id));
  }

  @GetMapping(path = "/{id}/users")
  public ResponseEntity<List<EnrollmentToCourse>> showStudentsInCourse(@PathVariable Long id) {

    return ResponseEntity.ok(this.iCourseService.getUsersInCourse(id));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<CourseResponse> addCourse(@Validated @RequestBody CourseRequest courseRequest) {

    return ResponseEntity.ok(this.iCourseService.create(courseRequest));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<CourseResponse> updateCourse(@PathVariable Long id,
      @Validated @RequestBody CourseRequest courseRequest) {

    return ResponseEntity.ok(this.iCourseService.update(courseRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Boolean> deleteCourse(@PathVariable Long id) {

    return ResponseEntity.ok(this.iCourseService.delete(id));
  }
}
