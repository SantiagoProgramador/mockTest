package com.Santiago.mockTest.api.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

  @NotBlank(message = "Type something in the message")
  private String messageContent;

  @NotNull(message = "The sender is required")
  private Long senderId;

  private Long receiverId;

  private Long courseId;
}
