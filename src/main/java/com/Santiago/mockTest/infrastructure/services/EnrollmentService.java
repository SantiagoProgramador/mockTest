package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.EnrollmentRequest;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IEnrollmentService;

@Service
public class EnrollmentService implements IEnrollmentService{

  @Override
  public EnrollmentResponse create(EnrollmentRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public EnrollmentResponse update(EnrollmentRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public EnrollmentResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<EnrollmentResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }
  
}
