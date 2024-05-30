package com.Santiago.mockTest.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Santiago.mockTest.domain.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<User> findByCourseId(Long id);
}
