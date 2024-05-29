package com.Santiago.mockTest.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String courseName;

  @Lob
  private String description;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "instructor_id", referencedColumnName = "id")
  private User instructor;

  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Lesson> lessons;

  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Message> messages;

  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Enrollment> enrollments;
}
