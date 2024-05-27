package com.Santiago.mockTest.domain.entities;

import java.util.List;

import com.Santiago.mockTest.util.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 40, nullable = false)
  private String username;
  @Column(length = 40, nullable = false)
  private String password;
  @Column(length = 40, nullable = false)
  private String email;
  @Column(length = 40, nullable = false)
  private String fullName;
  @Enumerated(EnumType.STRING)
  private UserRole role;

  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Enrollment> enrollments;

  @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Course> courses;

  @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Message> senderMessages;

  @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Message> receiverMessages;

  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Submission> submissions;
}
