package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.CourseRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.infrastructure.abstracts.ICourseService;

@Service
public class CourseService implements ICourseService{

  @Override
  public CourseResponse create(CourseRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public CourseResponse update(CourseRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public CourseResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<CourseResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }
  
}
