package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.EnrollmentRequest;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IEnrollmentService;

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
@RequestMapping(path = "/enrollments")
@AllArgsConstructor
public class EnrollmentController {

  @Autowired
  private final IEnrollmentService iEnrollmentService;

  @GetMapping(path = "/all")
  public ResponseEntity<List<EnrollmentResponse>> showAll() {

    return ResponseEntity.ok(this.iEnrollmentService.getAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<EnrollmentResponse> showEnrollment(@PathVariable Long id) {

    return ResponseEntity.ok(this.iEnrollmentService.findById(id));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<EnrollmentResponse> addEnrollment(@Validated @RequestBody EnrollmentRequest enrollmentRequest) {

    return ResponseEntity.ok(this.iEnrollmentService.create(enrollmentRequest));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id,
      @Validated @RequestBody EnrollmentRequest enrollmentRequest) {

    return ResponseEntity.ok(this.iEnrollmentService.update(enrollmentRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Boolean> deleteEnrollment(@PathVariable Long id) {

    return ResponseEntity.ok(this.iEnrollmentService.delete(id));
  }
}
