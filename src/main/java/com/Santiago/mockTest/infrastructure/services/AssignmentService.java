package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
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
  }

  @Override
  public AssignmentResponse update(AssignmentRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public boolean delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public AssignmentResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<AssignmentResponse> getAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }
}
