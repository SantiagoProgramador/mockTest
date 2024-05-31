package com.Santiago.mockTest.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santiago.mockTest.domain.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
  List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
