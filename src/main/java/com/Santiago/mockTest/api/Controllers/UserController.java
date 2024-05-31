package com.Santiago.mockTest.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.Santiago.mockTest.api.Dto.Request.UserRequest;
import com.Santiago.mockTest.api.Dto.Response.CourseResponse;
import com.Santiago.mockTest.api.Dto.Response.SubmissionToUser;
import com.Santiago.mockTest.api.Dto.Response.UserResponse;
import com.Santiago.mockTest.infrastructure.abstracts.IUserService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService iUserService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserResponse>> showAll() {

        return ResponseEntity.ok(this.iUserService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> showUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.iUserService.findById(id));
    }

    @GetMapping(path = "/{id}/submissions")
    public ResponseEntity<List<SubmissionToUser>> showSubmissionsInUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.iUserService.getSubmissionsInUser(id));
    }

    @GetMapping(path = "/{id}/courses")
    public ResponseEntity<List<CourseResponse>> showCoursesInUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.iUserService.getCoursesInUser(id));
    }

    @PostMapping(path = "/add")
    public ResponseEntity<UserResponse> addUser(@Validated @RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(this.iUserService.create(userRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,
            @Validated @RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(this.iUserService.update(userRequest, id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {

        return ResponseEntity.ok(this.iUserService.delete(id));
    }

}
