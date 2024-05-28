package com.Santiago.mockTest.infrastructure.abstracts;

import com.Santiago.mockTest.api.Dto.Request.MessageRequest;
import com.Santiago.mockTest.api.Dto.Response.MessageResponse;

public interface IMessageService extends BaseService<MessageRequest, MessageResponse, Long> {

}
