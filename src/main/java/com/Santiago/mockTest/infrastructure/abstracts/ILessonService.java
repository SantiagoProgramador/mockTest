package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.LessonRequest;
import com.Santiago.mockTest.api.Dto.Response.AssignmentToLesson;
import com.Santiago.mockTest.api.Dto.Response.LessonResponse;

public interface ILessonService extends BaseService<LessonRequest, LessonResponse, Long> {
    public List<AssignmentToLesson> getAssignmentsInALesson(Long id);
}
