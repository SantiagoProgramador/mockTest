package com.Santiago.mockTest.infrastructure.abstracts;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;

public interface IUserService extends BaseService<UserRequest, UserResponse, Long> {

}
