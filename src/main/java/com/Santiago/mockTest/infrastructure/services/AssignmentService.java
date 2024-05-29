package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.domain.entities.Assignment;
import com.Santiago.mockTest.domain.repositories.AssignmentRepository;
import com.Santiago.mockTest.infrastructure.abstracts.IAssignmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

  @Autowired
  private final AssignmentRepository assignmentRepository;

  private AssignmentResponse assignmentToAssignmentResponse(Assignment assignment) {
    AssignmentResponse assignmentResponse = new AssignmentResponse();
    BeanUtils.copyProperties(assignment, assignmentResponse);

    return assignmentResponse;
  }

  private Assignment assignmentRequestToAssignment(AssignmentRequest assignmentRequest, Assignment assignment) {
    BeanUtils.copyProperties(assignmentRequest, assignment);

    return assignment;
  }

  @Override
  public AssignmentResponse create(AssignmentRequest request) {
    Assignment assignment = new Assignment();
    this.assignmentRequestToAssignment(request, assignment);

    return this.assignmentToAssignmentResponse(this.assignmentRepository.save(assignment));
  }

  @Override
  public AssignmentResponse update(AssignmentRequest request, Long id) {
    Assignment assignment = findAssignment(id);
    this.assignmentRequestToAssignment(request, assignment);

    return this.assignmentToAssignmentResponse(this.assignmentRepository.save(assignment));
  }

  @Override
  public boolean delete(Long id) {
    Assignment assignment = findAssignment(id);
    this.assignmentRepository.delete(assignment);

    return true;
  }

  @Override
  public AssignmentResponse findById(Long id) {
    Assignment assignment = findAssignment(id);

    return this.assignmentToAssignmentResponse(assignment);
  }

  private Assignment findAssignment(Long id) {

    return this.assignmentRepository.findById(id).orElseThrow();
  }

  @Override
  public List<AssignmentResponse> getAll() {

    return this.assignmentRepository.findAll().stream().map(this::assignmentToAssignmentResponse).toList();
  }
}
