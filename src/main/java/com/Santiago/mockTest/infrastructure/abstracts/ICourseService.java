package com.Santiago.mockTest.infrastructure.abstracts;

import com.Santiago.mockTest.api.Dto.Request.CourseRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;

public interface ICourseService extends BaseService<CourseRequest, CourseResponse, Long> {
    public List<UserResponse> getAllInCourse(Long id);
}
