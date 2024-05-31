package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.AssignmentRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IAssignmentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/assignments")
@AllArgsConstructor
public class AssignmentController {

  @Autowired
  private final IAssignmentService iAssignmentService;

  @GetMapping(path = "/all")
  public ResponseEntity<List<AssignmentResponse>> showAll() {

    return ResponseEntity.ok(this.iAssignmentService.getAll());
  }

  @GetMapping(path = "/{id}/submissions")
  public ResponseEntity<List<SubmissionResponse>> showSubmissionsInAsignment(@PathVariable Long id) {

    return ResponseEntity.ok(this.iAssignmentService.getSubmissionsInAssignment(id));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<AssignmentResponse> showAssignment(@PathVariable Long id) {

    return ResponseEntity.ok(this.iAssignmentService.findById(id));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<AssignmentResponse> addAssignment(@Validated @RequestBody AssignmentRequest assignmentRequest) {

    return ResponseEntity.ok(this.iAssignmentService.create(assignmentRequest));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<AssignmentResponse> updateAssignment(@PathVariable Long id,
      @Validated @RequestBody AssignmentRequest assignmentRequest) {

    return ResponseEntity.ok(this.iAssignmentService.update(assignmentRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Boolean> deleteAssignment(@PathVariable Long id) {

    return ResponseEntity.ok(this.iAssignmentService.delete(id));
  }
}
