package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;

public interface IMessageService extends BaseService<MessageRequest, MessageResponse, Long> {
  public List<MessageResponse> getMessagesInUsers(Long senderId, Long receiverId);
}
