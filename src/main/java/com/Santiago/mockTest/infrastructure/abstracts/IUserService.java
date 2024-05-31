package com.Santiago.mockTest.infrastructure.abstracts;


import java.util.List;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionToUser;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;

public interface IUserService extends BaseService<UserRequest, UserResponse, Long> {
    public List<CourseResponse> getCoursesInUser(Long id);
    public List<SubmissionToUser> getSubmissionsInUser(Long id);
}
