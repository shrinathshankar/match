package com.match.mmr.controller;


import com.match.mmr.dto.request.TeamRequest;
import com.match.mmr.dto.response.TeamResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private PersonnelService personnelService;

    public TeamController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/create")
    public ResponseEntity<TeamResponse> makeTeams(@RequestBody TeamRequest teamRequest) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new TeamResponse(personnelService.calculateTeams(teamRequest.getPlayers())));
    }


}