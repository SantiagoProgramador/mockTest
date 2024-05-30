package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.SubmissionRequest;
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
import com.Santiago.mockTest.domain.repositories.SubmissionRepository;
import com.Santiago.mockTest.domain.repositories.UserRepository;
import com.Santiago.mockTest.infrastructure.abstracts.ISubmissionService;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements ISubmissionService {

  @Autowired
  private final SubmissionRepository submissionRepository;

  @Autowired
  private final AssignmentRepository assignmentRepository;

  @Autowired
  private final UserRepository userRepository;

  @Override
  public SubmissionResponse create(SubmissionRequest submissionRequest) {

    Submission submission = new Submission();

    this.submissionRequestToSubmission(submissionRequest, submission);

    return this.submissionToSubmissionResponse(this.submissionRepository.save(submission));
  }

  @Override
  public SubmissionResponse update(SubmissionRequest submissionRequest, Long id) {
    Submission submission = this.findSubmission(id);

    this.submissionRequestToSubmission(submissionRequest, submission);

    return this.submissionToSubmissionResponse(this.submissionRepository.save(submission));
  }

  @Override
  public boolean delete(Long id) {
    Submission submission = this.findSubmission(id);

    this.submissionRepository.delete(submission);

    return true;
  }

  @Override
  public SubmissionResponse findById(Long id) {
    Submission submission = this.findSubmission(id);

    return this.submissionToSubmissionResponse(submission);
  }

  private Submission findSubmission(Long id) {

    return this.submissionRepository.findById(id).orElseThrow();
  }

  @Override
  public List<SubmissionResponse> getAll() {
    return this.submissionRepository.findAll().stream().map(this::submissionToSubmissionResponse).toList();
  }

  private SubmissionResponse submissionToSubmissionResponse(Submission submission) {
    SubmissionResponse submissionResponse = new SubmissionResponse();

    BeanUtils.copyProperties(submission, submissionResponse);
    submissionResponse.setAssignmentResponse(this.assignmentToAssignmentResponse(submission.getAssignment()));
    submissionResponse.setStudent(this.userToUserResponse(submission.getStudent()));

    return submissionResponse;
  }

  private Submission submissionRequestToSubmission(SubmissionRequest submissionRequest, Submission submission) {

    BeanUtils.copyProperties(submissionRequest, submission);
    submission.setAssignment(this.assignmentRepository.findById(submissionRequest.getAssignmentId())
        .orElseThrow(() -> new IdNotFoundException("Assignments")));
    submission.setStudent(this.userRepository.findById(submissionRequest.getStudentId())
        .orElseThrow(() -> new IdNotFoundException("Users")));

    return submission;
  }

  private UserResponse userToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    BeanUtils.copyProperties(user, userResponse);

    return userResponse;

  }

  private AssignmentResponse assignmentToAssignmentResponse(Assignment assignment) {
    AssignmentResponse assignmentResponse = new AssignmentResponse();
    BeanUtils.copyProperties(assignment, assignmentResponse);
    assignmentResponse.setLessonResponse(this.lessonToLessonResponse(assignment.getLesson()));

    return assignmentResponse;
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
    return courseResponse;
  }
}
