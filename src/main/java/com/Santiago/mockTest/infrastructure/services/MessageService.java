package com.Santiago.mockTest.infrastructure.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.domain.entities.Course;
import com.Santiago.mockTest.domain.entities.Message;
import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.domain.repositories.CourseRepository;
import com.Santiago.mockTest.domain.repositories.MessageRepository;
import com.Santiago.mockTest.domain.repositories.UserRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IMessageService;
import com.Santiago.mockTest.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessageService implements IMessageService {

  @Autowired
  private final MessageRepository messageRepository;

  @Autowired
  private final CourseRepository courseRepository;

  @Autowired
  private final UserRepository userRepository;

  @Override
  public MessageResponse create(MessageRequest request) {
    Message message = new Message();

    this.messageRequestToMessage(request, message);

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

  private Message messageRequestToMessage(MessageRequest messageRequest, Message message) {

    if (messageRequest.getCourseId() != null) {
      message.setCourse(this.courseRepository.findById(messageRequest.getCourseId())
          .orElseThrow(() -> new IdNotFoundException("courses")));
    }
    if (messageRequest.getReceiverId() != null) {
      message.setReceiver(this.userRepository.findById(messageRequest.getReceiverId())
          .orElseThrow(() -> new IdNotFoundException("User")));
    }

    message.setSender(this.userRepository.findById(messageRequest.getSenderId())
        .orElseThrow(() -> new IdNotFoundException("messages")));
    message.setMessageContent(messageRequest.getMessageContent());
    message.setSentDate(LocalDate.now());

    return message;
  }

  private MessageResponse messageToMessageResponse(Message message) {
    MessageResponse messageResponse = new MessageResponse();

    if (message.getCourse() != null) {
      messageResponse.setCourse(this.courseToCourseResponse(message.getCourse()));

    }
    if (message.getReceiver() != null) {
      messageResponse.setReceiver(this.userToUserResponse(message.getReceiver()));

    }
    messageResponse.setSender(this.userToUserResponse(message.getSender()));
    messageResponse.setMessageContent(message.getMessageContent());
    messageResponse.setSentDate(message.getSentDate());
    messageResponse.setId(message.getId());

    return messageResponse;
  }

  // @Override
  // public List<MessageResponse> findByCourseId(Long id) {
  // return
  // this.messageRepository.findByCourseId(id).stream().map(this::messageToMessageResponse).toList();
  // }

  private CourseResponse courseToCourseResponse(Course course) {
    CourseResponse courseResponse = new CourseResponse();

    courseResponse.setCourseName(course.getCourseName());
    courseResponse.setDescription(course.getDescription());
    courseResponse.setId(course.getId());

    return courseResponse;
  }

  private UserResponse userToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();

    BeanUtils.copyProperties(user, userResponse);

    return userResponse;
  }

}
