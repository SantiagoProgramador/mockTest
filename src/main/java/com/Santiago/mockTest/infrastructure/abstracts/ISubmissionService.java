package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.SubmissionRequest;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;

public interface ISubmissionService extends BaseService<SubmissionRequest, SubmissionResponse, Long> {
}
