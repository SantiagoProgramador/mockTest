package com.Santiago.mockTest.api.Dto.Request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {

  @NotNull(message = "The student is required")
  private Long studentId;

  @NotNull(message = "The course is required")
  private Long courseId;
}
