package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.SubmissionRequest;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;
import com.Santiago.mockTest.domain.entities.Submission;
import com.Santiago.mockTest.domain.repositories.SubmissionRepository;
import com.Santiago.mockTest.infrastructure.abstracts.ISubmissionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements ISubmissionService {

  @Autowired
  private final SubmissionRepository submissionRepository;

  @Override
  public SubmissionResponse create(SubmissionRequest submissionRequest) {

    Submission submission = new Submission();

    BeanUtils.copyProperties(submissionRequest, submission);

    return this.submissionToSubmissionResponse(this.submissionRepository.save(submission));
  }

  @Override
  public SubmissionResponse update(SubmissionRequest submissionRequest, Long id) {
    Submission submission = this.findSubmission(id);

    this.submissionRequestToSubmission(submissionRequest, submission);

    return this.submissionToSubmissionResponse(this.submissionRepository.save(submission));
  }

  @Override
  public boolean delete(Long id) {
    Submission submission = this.findSubmission(id);

    this.submissionRepository.delete(submission);

    return true;
  }

  @Override
  public SubmissionResponse findById(Long id) {
    Submission submission = this.findSubmission(id);

    return this.submissionToSubmissionResponse(submission);
  }

  private Submission findSubmission(Long id) {

    return this.submissionRepository.findById(id).orElseThrow();
  }

  @Override
  public List<SubmissionResponse> getAll() {
    return this.submissionRepository.findAll().stream().map(this::submissionToSubmissionResponse).toList();
  }

  private SubmissionResponse submissionToSubmissionResponse(Submission submission) {
    SubmissionResponse submissionResponse = new SubmissionResponse();

    BeanUtils.copyProperties(submission, submissionResponse);

    return submissionResponse;
  }

  private Submission submissionRequestToSubmission(SubmissionRequest submissionRequest, Submission submission) {
    BeanUtils.copyProperties(submissionRequest, submission);

    return submission;
  }
}
