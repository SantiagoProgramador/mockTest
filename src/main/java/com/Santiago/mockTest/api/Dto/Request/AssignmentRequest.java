package com.Santiago.mockTest.api.Dto.Request;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {

  @NotEmpty(message = "The title of the assignment is required")
  private String assignmentTitle;

  private String description;

  @Future(message = "The due date has to have at least 1 hour to deliver")
  private LocalDate dueDate;

  @NotNull(message = "Need to specify whats the lesson of the assignment")
  private int lessonId;

}
