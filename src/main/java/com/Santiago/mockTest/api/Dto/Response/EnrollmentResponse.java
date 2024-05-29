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
public class EnrollmentResponse {

  private Long id;
  private LocalDate enrollmentDate;
  private UserResponse userResponse;
  private CourseResponse courseResponse;
}
