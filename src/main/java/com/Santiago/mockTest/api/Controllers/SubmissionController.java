package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.SubmissionRequest;
import com.Santiago.mockTest.api.Dto.Response.SubmissionResponse;
import com.Santiago.mockTest.infrastructure.abstracts.ISubmissionService;

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
@RequestMapping(path = "/submissions")
@AllArgsConstructor
public class SubmissionController {
    @Autowired
    private final ISubmissionService iSubmissionService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<SubmissionResponse>> showAll(){

        return ResponseEntity.ok(this.iSubmissionService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SubmissionResponse> showSubmission(@PathVariable Long id){

        return ResponseEntity.ok(this.iSubmissionService.findById(id));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<SubmissionResponse> addSubmission(@Validated @RequestBody SubmissionRequest submissionRequest){

        return ResponseEntity.ok(this.iSubmissionService.create(submissionRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SubmissionResponse> updateSubmission(@PathVariable Long id, @Validated @RequestBody SubmissionRequest submissionRequest){

        return ResponseEntity.ok(this.iSubmissionService.update(submissionRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteSubmission(@PathVariable Long id){

        return ResponseEntity.ok(this.iSubmissionService.delete(id));
    }
}
