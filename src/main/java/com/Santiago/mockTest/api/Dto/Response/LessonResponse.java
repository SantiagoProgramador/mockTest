package com.Santiago.mockTest.api.Dto.Response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonResponse {

  private Long id;
  private String content;
  private String lessonTitle;
  private CourseResponse courseResponse;
}
