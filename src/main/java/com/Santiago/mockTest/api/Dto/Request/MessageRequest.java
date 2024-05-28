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
  private int senderId;

  @NotNull(message = "The receiver is required")
  private int receiverId;

  @NotNull(message = "You must specify which course you are contacting your instructor for.")
  private int courseId;
}
