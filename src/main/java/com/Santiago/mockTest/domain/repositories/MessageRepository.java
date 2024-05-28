package com.Santiago.mockTest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santiago.mockTest.domain.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
