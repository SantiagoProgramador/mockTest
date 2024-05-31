package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.Assignment;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.entities.Lesson;
import com.Santiago.mockTest.domain.entities.Submission;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.AssignmentRepository;
import com.Santiago.mockTest.domain.repositories.LessonRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IAssignmentService;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

  @Autowired
  private final AssignmentRepository assignmentRepository;

  @Autowired
  private final LessonRepository lessonRepository;

  private AssignmentResponse assignmentToAssignmentResponse(Assignment assignment) {
    AssignmentResponse assignmentResponse = new AssignmentResponse();
    BeanUtils.copyProperties(assignment, assignmentResponse);
    assignmentResponse.setLessonResponse(this.lessonToLessonResponse(assignment.getLesson()));
    assignmentResponse.setIsCompleted(false);

    return assignmentResponse;
  }

  private Assignment assignmentRequestToAssignment(AssignmentRequest assignmentRequest, Assignment assignment) {
    BeanUtils.copyProperties(assignmentRequest, assignment);
    assignment.setLesson(this.lessonRepository.findById(assignmentRequest.getLessonId())
        .orElseThrow(() -> new IdNotFoundException("Lessons")));

    return assignment;
  }

  @Override
  public AssignmentResponse create(AssignmentRequest request) {
    Assignment assignment = new Assignment();
    this.assignmentRequestToAssignment(request, assignment);

    return this.assignmentToAssignmentResponse(this.assignmentRepository.save(assignment));
  }

  @Override
  public AssignmentResponse update(AssignmentRequest request, Long id) {
    Assignment assignment = findAssignment(id);
    this.assignmentRequestToAssignment(request, assignment);

    return this.assignmentToAssignmentResponse(this.assignmentRepository.save(assignment));
  }

  @Override
  public boolean delete(Long id) {
    Assignment assignment = findAssignment(id);
    this.assignmentRepository.delete(assignment);

    return true;
  }

  @Override
  public AssignmentResponse findById(Long id) {
    Assignment assignment = findAssignment(id);

    return this.assignmentToAssignmentResponse(assignment);
  }

  private Assignment findAssignment(Long id) {

    return this.assignmentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Assignments"));
  }

  @Override
  public List<AssignmentResponse> getAll() {

    return this.assignmentRepository.findAll().stream().map(this::assignmentToAssignmentResponse).toList();
  }

  private LessonResponse lessonToLessonResponse(Lesson lesson) {
    LessonResponse lessonResponse = new LessonResponse();
    BeanUtils.copyProperties(lesson, lessonResponse);
    lessonResponse.setCourseResponse(this.courseToCourseResponse(lesson.getCourse()));
    return lessonResponse;
  }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();
    BeanUtils.copyProperties(course, courseResponse);
    if (course.getInstructor() != null) {
      courseResponse.setInstructor(this.userToUserResponse(course.getInstructor()));
    }
    return courseResponse;
  }

  private UserResponse userToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    BeanUtils.copyProperties(user, userResponse);
    return userResponse;
  }

  @Override
  public List<SubmissionResponse> getSubmissionsInAssignment(Long id) {
    Assignment assignment = this.findAssignment(id);

    return assignment.getSubmissions().stream().map(this::submissionToSubmissionResponse).toList();
  }

  private SubmissionResponse submissionToSubmissionResponse(Submission submission) {
    SubmissionResponse submissionResponse = new SubmissionResponse();
    BeanUtils.copyProperties(submission, submissionResponse);

    return submissionResponse;
  }
}
