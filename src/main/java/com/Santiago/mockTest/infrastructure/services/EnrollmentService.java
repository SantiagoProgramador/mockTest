package com.Santiago.mockTest.infrastructure.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.EnrollmentRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentResponse;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.entities.Enrollment;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.CourseRepository;
import com.Santiago.mockTest.domain.repositories.EnrollmentRepository;
import com.Santiago.mockTest.domain.repositories.UserRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IEnrollmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnrollmentService implements IEnrollmentService {

  @Autowired
  private final EnrollmentRepository enrollmentRepository;
  @Autowired
  private final CourseRepository courseRepository;
  @Autowired
  private final UserRepository userRepository;

  @Override
  public EnrollmentResponse create(EnrollmentRequest request) {
    Enrollment enrollment = new Enrollment();
    this.enrollmentRequestToEnrollment(request, enrollment);

    return this.enrollmentToEnrollmentResponse(this.enrollmentRepository.save(enrollment));
  }

  @Override
  public EnrollmentResponse update(EnrollmentRequest request, Long id) {
    Enrollment enrollment = this.findEnrollment(id);
    this.enrollmentRequestToEnrollment(request, enrollment);
    return this.enrollmentToEnrollmentResponse(this.enrollmentRepository.save(enrollment));
  }

  @Override
  public boolean delete(Long id) {
    Enrollment enrollment = this.findEnrollment(id);
    this.enrollmentRepository.delete(enrollment);
    return true;
  }

  @Override
  public EnrollmentResponse findById(Long id) {
    Enrollment enrollment = this.findEnrollment(id);

    return this.enrollmentToEnrollmentResponse(enrollment);
  }

  private Enrollment findEnrollment(Long id) {
    return this.enrollmentRepository.findById(id).orElseThrow();
  }

  @Override
  public List<EnrollmentResponse> getAll() {

    return this.enrollmentRepository.findAll().stream().map(this::enrollmentToEnrollmentResponse).toList();
  }

  private EnrollmentResponse enrollmentToEnrollmentResponse(Enrollment enrollment) {
    EnrollmentResponse enrollmentResponse = new EnrollmentResponse();

    BeanUtils.copyProperties(enrollment, enrollmentResponse);
    enrollmentResponse.setCourseResponse(this.courseToCourseResponse(enrollment.getCourse()));
    enrollmentResponse.setUserResponse(this.userToUserResponse(enrollment.getStudent()));

    return enrollmentResponse;
  }

  private Enrollment enrollmentRequestToEnrollment(EnrollmentRequest enrollmentRequest, Enrollment enrollment) {
    enrollment.setCourse(this.courseRepository.findById(enrollmentRequest.getCourseId()).orElseThrow());
    enrollment.setStudent(this.userRepository.findById(enrollmentRequest.getStudentId()).orElseThrow());
    enrollment.setEnrollmentDate(LocalDate.now());

    return enrollment;
  }

  // @Override
  // public List<EnrollmentResponse> findByStudentId(Long id) {
  // return
  // this.enrollmentRepository.findByStudentId(id).stream().map(this::enrollmentToEnrollmentResponse).toList();
  // }

  private UserResponse userToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();

    BeanUtils.copyProperties(user, userResponse);

    return userResponse;
  }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();

    BeanUtils.copyProperties(course, courseResponse);

    return courseResponse;
  }
}
