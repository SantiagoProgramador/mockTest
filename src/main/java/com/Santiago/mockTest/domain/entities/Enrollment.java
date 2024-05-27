package com.Santiago.mockTest.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "enrollments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private LocalDate enrollmentDate;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id", referencedColumnName = "id")
  private User student;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", referencedColumnName = "id")
  private Course course;

}
