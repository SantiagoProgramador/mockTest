package com.Santiago.mockTest.api.Dto.Response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentToLesson {
  private Long id;
  private String assignmentTitle;
  private String description;
  private LocalDate dueDate;
  private Boolean isCompleted;
}
