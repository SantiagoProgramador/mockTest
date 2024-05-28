package com.Santiago.mockTest.api.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionRequest {

  @NotBlank(message = "Type the content of the task")
  private String content;

  @NotNull(message = "The student is required")
  private int studentId;

  @NotNull(message = "The assignment is required")
  private int assignmentId;
}
