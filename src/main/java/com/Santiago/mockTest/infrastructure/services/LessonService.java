package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.LessonRequest;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;
import com.Santiago.mockTest.infrastructure.abstracts.ILessonService;

@Service
public class LessonService implements ILessonService {

  @Override
  public LessonResponse create(LessonRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public LessonResponse update(LessonRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public LessonResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<LessonResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
