package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IMessageService;

@Service
public class MessageService implements IMessageService {

  @Override
  public MessageResponse create(MessageRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public MessageResponse update(MessageRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public MessageResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<MessageResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

}
