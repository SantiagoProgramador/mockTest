package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.LessonRequest;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;
import com.Santiago.mockTest.infrastructure.abstracts.ILessonService;

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
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {

  @Autowired
  private final ILessonService iLessonService;

  @GetMapping(path = "/all")
  public ResponseEntity<List<LessonResponse>> showAll() {

    return ResponseEntity.ok(this.iLessonService.getAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<LessonResponse> showLesson(@PathVariable Long id) {

    return ResponseEntity.ok(this.iLessonService.findById(id));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<LessonResponse> addLesson(@Validated @RequestBody LessonRequest lessonRequest) {

    return ResponseEntity.ok(this.iLessonService.create(lessonRequest));
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<LessonResponse> updateLesson(@PathVariable Long id,
      @Validated @RequestBody LessonRequest lessonRequest) {

    return ResponseEntity.ok(this.iLessonService.update(lessonRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Boolean> deleteLesson(@PathVariable Long id) {

    return ResponseEntity.ok(this.iLessonService.delete(id));
  }
}
