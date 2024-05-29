package com.Santiago.mockTest.infrastructure.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Santiago.mockTest.api.Dto.Request.LessonRequest;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;
import com.Santiago.mockTest.domain.entities.Lesson;
import com.Santiago.mockTest.domain.repositories.LessonRepository;
import com.Santiago.mockTest.infrastructure.abstracts.ILessonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

  @Autowired
  private final LessonRepository lessonRepository;

  @Override
  public LessonResponse create(LessonRequest request) {
    Lesson lesson = new Lesson();
    BeanUtils.copyProperties(request, lesson);

    return this.lessonToLessonResponse(this.lessonRepository.save(lesson));
  }

  @Override
  public LessonResponse update(LessonRequest request, Long id) {
    Lesson lesson = findLesson(id);

    this.lessonRequestToLesson(request, lesson);

    return this.lessonToLessonResponse(this.lessonRepository.save(lesson));
  }

  @Override
  public boolean delete(Long id) {
    Lesson lesson = findLesson(id);
    this.lessonRepository.delete(lesson);

    return true;
  }

  @Override
  public LessonResponse findById(Long id) {
    Lesson lesson = this.findLesson(id);

    return this.lessonToLessonResponse(lesson);
  }

  private Lesson findLesson(Long id) {
    return this.lessonRepository.findById(id).orElseThrow();
  }

  @Override
  public List<LessonResponse> getAll() {

    return this.lessonRepository.findAll().stream().map(this::lessonToLessonResponse).toList();
  }

  private LessonResponse lessonToLessonResponse(Lesson lesson) {
    LessonResponse lessonResponse = new LessonResponse();

    BeanUtils.copyProperties(lesson, lessonResponse);

    return lessonResponse;
  }

  private Lesson lessonRequestToLesson(LessonRequest lessonRequest, Lesson lesson) {
    BeanUtils.copyProperties(lessonRequest, lesson);

    return lesson;
  }
}
