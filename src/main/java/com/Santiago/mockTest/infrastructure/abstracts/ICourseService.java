package com.Santiago.mockTest.infrastructure.abstracts;

import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.CourseRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.EnrollmentToCourse;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;
import com.Santiago.mockTest.api.Dto.Response.MessageToCourse;

public interface ICourseService extends BaseService<CourseRequest, CourseResponse, Long> {
  public List<EnrollmentToCourse> getUsersInCourse(Long id);

  public List<MessageToCourse> getMessagesInCourse(Long id);
}
