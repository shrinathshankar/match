package com.match.mmr.controller;

import com.match.mmr.model.request.UserRequest;
import com.match.mmr.model.response.UserResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private PersonnelService personnelService;

    public UserController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(personnelService.addUser(userRequest));
    }

    @PostMapping("/validate")
    public ResponseEntity<UserResponse> validate(@RequestBody UserRequest userRequest) {
        return  ResponseEntity.status(HttpStatus.OK).body(personnelService.findUser(userRequest));
    }

    //add more later
}
