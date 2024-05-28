package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IUserService;

@Service
public class AssignmentService implements IUserService {

  @Override
  public UserResponse create(UserRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public UserResponse update(UserRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public UserResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<UserResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
