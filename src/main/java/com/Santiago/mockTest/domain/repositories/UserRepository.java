package com.Santiago.mockTest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santiago.mockTest.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<Course> findByUserId(Long id);
}
