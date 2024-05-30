package com.Santiago.mockTest.infrastructure.abstracts;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;

public interface IAssignmentService extends BaseService<AssignmentRequest,AssignmentResponse,Long> {
  public List<AssignmentResponse> getAllInLesson(Long id);

  public List<SubmissionResponse> getAllInAssignment(Long id);
}
