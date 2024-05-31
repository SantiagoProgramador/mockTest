package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionToUser;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.Assignment;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.entities.Submission;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.UserRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IUserService;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

  @Autowired
  private final UserRepository userRepository;

  @Override
  public UserResponse create(UserRequest request) {

    User user = new User();

    BeanUtils.copyProperties(request, user);

    return this.userToUserResponse(this.userRepository.save(user));
  }

  @Override
  public UserResponse update(UserRequest request, Long id) {
    User user = this.findUser(id);

    this.userRequestToUser(request, user);

    return this.userToUserResponse(this.userRepository.save(user));
  }

  @Override
  public boolean delete(Long id) {
    User user = this.findUser(id);

    this.userRepository.delete(user);

    return true;
  }

  @Override
  public UserResponse findById(Long id) {
    User user = this.findUser(id);

    return this.userToUserResponse(user);
  }

  private User findUser(Long id) {

    return this.userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("users"));
  }

  @Override
  public List<UserResponse> getAll() {
    return this.userRepository.findAll().stream().map(this::userToUserResponse).toList();
  }

  private UserResponse userToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();

    BeanUtils.copyProperties(user, userResponse);

    return userResponse;
  }

  private User userRequestToUser(UserRequest userRequest, User user) {
    BeanUtils.copyProperties(userRequest, user);

    return user;
  }

  @Override
  public List<CourseResponse> getCoursesInUser(Long id) {
    User user = this.findUser(id);

    return user.getCourses().stream().map(this::courseToCourseResponse).toList();
  }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();
    BeanUtils.copyProperties(course, courseResponse);
    return courseResponse;
  }

  @Override
  public List<SubmissionToUser> getSubmissionsInUser(Long id) {
    User user = this.findUser(id);

    return user.getSubmissions().stream().map(this::submissionToSubmissionToUser).toList();
  }

  private SubmissionToUser submissionToSubmissionToUser(Submission submission) {
    SubmissionToUser submissionToUser = new SubmissionToUser();
    BeanUtils.copyProperties(submission, submissionToUser);
    submissionToUser.setAssignmentResponse(this.assignmentToAssignmentResponse(submission.getAssignment()));
    return submissionToUser;
  }

  private AssignmentResponse assignmentToAssignmentResponse(Assignment assignment) {
    AssignmentResponse assignmentResponse = new AssignmentResponse();
    BeanUtils.copyProperties(assignment, assignmentResponse);
    return assignmentResponse;
  }

}
