package com.Santiago.mockTest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santiago.mockTest.domain.entities.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long>{
    List<Assignment> findByLessonId(Long id);
    List<Submission> findByAssignmentId(Long id);
}
