package com.match.mmr.controller;


import com.match.mmr.model.request.GameRequest;
import com.match.mmr.model.request.TeamRequest;
import com.match.mmr.model.response.TeamResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/game")
    @ResponseStatus(code = HttpStatus.OK)
    public void resolveGame(@RequestBody GameRequest gameRequest) {
        personnelService.newRating(gameRequest.getTeams().get(0), gameRequest.getTeams().get(1));
    }


}