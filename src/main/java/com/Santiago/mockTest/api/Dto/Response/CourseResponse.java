package com.Santiago.mockTest.api.Dto.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

  private Long id;
  private String courseName;
  private String description;
  private UserResponse instructor;
}
