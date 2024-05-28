package com.Santiago.mockTest.api.Dto.Request;

import com.Santiago.mockTest.util.enums.UserRole;

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
public class UserRequest {

  @NotBlank(message = "The username is required")
  private String username;

  @NotBlank(message = "The password is required")
  private String password;

  @NotBlank(message = "The email is required")
  private String email;

  @NotBlank(message = "Type the full name with first name and last name")
  private String fullName;

  @NotNull(message = "Specify the rol of the user")
  private UserRole role;

}
