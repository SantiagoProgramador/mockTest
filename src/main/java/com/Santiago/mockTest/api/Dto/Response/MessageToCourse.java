package com.Santiago.mockTest.api.Dto.Response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageToCourse {
  private UserResponse sender;
  private UserResponse receiver;
  private Long id;
  private String messageContent;
  private LocalDate sentDate;
}
