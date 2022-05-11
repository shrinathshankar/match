package com.match.mmr.controller;

import com.match.mmr.dto.TeamRequest;
import com.match.mmr.dto.TeamResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EloController {

    private PersonnelService personnelService;

    public EloController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamResponse> makeTeams(@RequestBody TeamRequest teamRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new TeamResponse(personnelService.calculateTeams(teamRequest.getPlayers())));
    }
}