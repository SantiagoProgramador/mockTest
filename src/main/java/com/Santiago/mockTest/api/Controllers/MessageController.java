package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IMessageService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/messages")
@AllArgsConstructor
public class MessageController {

  @Autowired
  private final IMessageService iMessageService;

  @GetMapping(path = "/all")
  public ResponseEntity<List<MessageResponse>> showAll() {

    return ResponseEntity.ok(this.iMessageService.getAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<MessageResponse> showMessage(@PathVariable Long id) {

    return ResponseEntity.ok(this.iMessageService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<MessageResponse>> showMessagesInUsers(@RequestParam Long senderId,
      @RequestParam Long receiverId) {

    return ResponseEntity.ok(this.iMessageService.getMessagesInUsers(senderId, receiverId));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<MessageResponse> addMessage(@Validated @RequestBody MessageRequest messageRequest) {

    return ResponseEntity.ok(this.iMessageService.create(messageRequest));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<MessageResponse> updateMessage(@PathVariable Long id,
      @Validated @RequestBody MessageRequest messageRequest) {

    return ResponseEntity.ok(this.iMessageService.update(messageRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Boolean> deleteMessage(@PathVariable Long id) {

    return ResponseEntity.ok(this.iMessageService.delete(id));
  }
}
