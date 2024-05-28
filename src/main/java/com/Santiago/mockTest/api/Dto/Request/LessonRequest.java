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
public class LessonRequest {

  @NotBlank(message = "The title is required")
  private String lessonTitle;

  @NotBlank(message = "The content of the lesson is required")
  private String content;

  @NotNull(message = "The course is needed")
  private int courseId;

}
