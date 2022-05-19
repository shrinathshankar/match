package com.match.mmr.controller;

import com.match.mmr.model.request.UserRequest;
import com.match.mmr.model.response.UserResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private PersonnelService personnelService;

    public UserController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponse(personnelService.addUser(userRequest)));
    }

    //add more later
}
