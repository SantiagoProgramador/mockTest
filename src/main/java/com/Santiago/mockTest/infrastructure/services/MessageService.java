package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;
import com.Santiago.mockTest.domain.entities.Message;
import com.Santiago.mockTest.domain.repositories.MessageRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IMessageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService {

  @Autowired
  private final MessageRepository messageRepository;

  @Override
  public MessageResponse create(MessageRequest request) {
    Message message = new Message();

    BeanUtils.copyProperties(request, message);

    return this.messageToMessageResponse(this.messageRepository.save(message));
  }

  @Override
  public MessageResponse update(MessageRequest request, Long id) {
    Message message = findMessage(id);

    this.messageRequestToMessage(request, message);

    return this.messageToMessageResponse(this.messageRepository.save(message));
  }

  @Override
  public boolean delete(Long id) {
    Message message = findMessage(id);
    this.messageRepository.delete(message);

    return true;
  }

  @Override
  public MessageResponse findById(Long id) {
    Message message = this.findMessage(id);

    return this.messageToMessageResponse(message);
  }

  private Message findMessage(Long id) {

    return this.messageRepository.findById(id).orElseThrow();
  }

  @Override
  public List<MessageResponse> getAll() {

    return this.messageRepository.findAll().stream().map(this::messageToMessageResponse).toList();
  }

  private MessageResponse messageToMessageResponse(Message message) {
    MessageResponse messageResponse = new MessageResponse();

    BeanUtils.copyProperties(message, messageResponse);

    return messageResponse;
  }

  private Message messageRequestToMessage(MessageRequest messageRequest, Message message) {
    BeanUtils.copyProperties(messageRequest, message);

    return message;
  }
}
