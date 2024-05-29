package com.Santiago.mockTest.api.Dto.Response;

import com.Santiago.mockTest.util.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  private Long id;
  private String username;
  private String email;
  private UserRole role;
  private String fullName;
  private String password;
}
