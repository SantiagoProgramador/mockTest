package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.EnrollmentRequest;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentResponse;
import com.Santiago.mockTest.domain.entities.Enrollment;
import com.Santiago.mockTest.domain.repositories.EnrollmentRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IEnrollmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnrollmentService implements IEnrollmentService {

  @Autowired
  private final EnrollmentRepository enrollmentRepository;

  @Override
  public EnrollmentResponse create(EnrollmentRequest request) {
    Enrollment enrollment = new Enrollment();
    BeanUtils.copyProperties(request, enrollment);

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

    return enrollmentResponse;
  }

  private Enrollment enrollmentRequestToEnrollment(EnrollmentRequest enrollmentRequest, Enrollment enrollment) {
    BeanUtils.copyProperties(enrollmentRequest, enrollment);

    return enrollment;
  }
}
