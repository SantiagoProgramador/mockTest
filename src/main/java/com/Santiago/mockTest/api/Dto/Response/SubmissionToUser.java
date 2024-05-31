package com.Santiago.mockTest.api.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionToUser {

  private AssignmentResponse assignmentResponse;
  private Long id;
  private String content;
  private double grade;

}
