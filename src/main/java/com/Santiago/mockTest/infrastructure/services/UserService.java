package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.UserRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IUserService;

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

    return this.userRepository.findById(id).orElseThrow();
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

  @Override
  public List<CourseResponse> getAllInUser(Long id ){

    return this.userRepository.findByUserId(id).stream().map(this::courseToCourseResponse).toList();
  }

  private User userRequestToUser(UserRequest userRequest, User user) {
    BeanUtils.copyProperties(userRequest, user);

    return user;
  }

  private CourseResponse courseToCourseResponse(Course course){
    CourseResponse courseResponse = new CourseResponse();

    BeanUtils.copyProperties(course,courseResponse);

    return courseResponse;
  }
}
