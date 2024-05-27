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

@Entity(name = "lessons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String lessonTitle;

  @Lob
  private String content;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id", referencedColumnName = "id")
  private Course course;

  @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Assignment> assignments;
}
