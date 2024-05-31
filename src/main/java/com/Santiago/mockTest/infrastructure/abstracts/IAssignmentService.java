package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;

public interface IAssignmentService extends BaseService<AssignmentRequest, AssignmentResponse, Long> {
  public List<SubmissionResponse> getSubmissionsInAssignment(Long id);
}
