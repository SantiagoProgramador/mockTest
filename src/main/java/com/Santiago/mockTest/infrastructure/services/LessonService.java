package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.LessonRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.AssignmentToLesson;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.Assignment;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.entities.Lesson;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.CourseRepository;
import com.Santiago.mockTest.domain.repositories.LessonRepository;
import com.Santiago.mockTest.infrastructure.abstracts.ILessonService;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

  @Autowired
  private final LessonRepository lessonRepository;

  @Autowired
  private final CourseRepository courseRepository;

  @Override
  public LessonResponse create(LessonRequest request) {
    Lesson lesson = new Lesson();
    this.lessonRequestToLesson(request, lesson);

    return this.lessonToLessonResponse(this.lessonRepository.save(lesson));
  }

  @Override
  public LessonResponse update(LessonRequest request, Long id) {
    Lesson lesson = findLesson(id);

    this.lessonRequestToLesson(request, lesson);

    return this.lessonToLessonResponse(this.lessonRepository.save(lesson));
  }

  @Override
  public boolean delete(Long id) {
    Lesson lesson = findLesson(id);
    this.lessonRepository.delete(lesson);

    return true;
  }

  @Override
  public LessonResponse findById(Long id) {
    Lesson lesson = this.findLesson(id);

    return this.lessonToLessonResponse(lesson);
  }

  private Lesson findLesson(Long id) {
    return this.lessonRepository.findById(id).orElseThrow();
  }

  @Override
  public List<LessonResponse> getAll() {

    return this.lessonRepository.findAll().stream().map(this::lessonToLessonResponse).toList();
  }

  private LessonResponse lessonToLessonResponse(Lesson lesson) {
    LessonResponse lessonResponse = new LessonResponse();

    BeanUtils.copyProperties(lesson, lessonResponse);
    lessonResponse.setCourseResponse(this.courseToCourseResponse(lesson.getCourse()));

    return lessonResponse;
  }

  private Lesson lessonRequestToLesson(LessonRequest lessonRequest, Lesson lesson) {
    BeanUtils.copyProperties(lessonRequest, lesson);
    lesson.setCourse(this.courseRepository.findById(lessonRequest.getCourseId())
        .orElseThrow(() -> new IdNotFoundException("Courses")));

    return lesson;
  }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();
    BeanUtils.copyProperties(course, courseResponse);
    if (course.getInstructor() != null)
      courseResponse.setInstructor(this.userToUserReponse(course.getInstructor()));
    return courseResponse;
  }

  private UserResponse userToUserReponse(User user) {
    UserResponse userResponse = new UserResponse();
    BeanUtils.copyProperties(user, userResponse);
    return userResponse;
  }

  @Override
  public List<AssignmentToLesson> getAssignmentsInALesson(Long id) {
    Lesson lesson = this.findLesson(id);

    return lesson.getAssignments().stream().map(this::assignmentToAssignmentToLesson).toList();
  }

  private AssignmentToLesson assignmentToAssignmentToLesson(Assignment assignment) {
    AssignmentToLesson assignmentResponse = new AssignmentToLesson();
    BeanUtils.copyProperties(assignment, assignmentResponse);

    return assignmentResponse;
  }
}
