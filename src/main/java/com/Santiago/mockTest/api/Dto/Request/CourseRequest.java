package com.Santiago.mockTest.api.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

  @NotBlank(message = "Write the course name")
  private String courseName;

  @NotBlank(message = "The description is needed")
  private String description;

  private int instructorId;

}
