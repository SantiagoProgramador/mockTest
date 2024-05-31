package com.Santiago.mockTest.infrastructure.helpers;

import org.springframework.stereotype.Component;

import com.Santiago.mockTest.domain.entities.User;
import com.Santiago.mockTest.util.enums.UserRole;
import com.Santiago.mockTest.util.exceptions.UnauthorizedException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserHelper {
    
    public void checkUserRole(User user){
        
        if (user.getRole() != UserRole.INSTRUCTOR) {
            throw new UnauthorizedException();
        }
    }
}
