package com.match.mmr.controller;

import com.match.mmr.dto.request.PlayerRequest;
import com.match.mmr.dto.response.PlayersResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PersonnelService personnelService;

    public PlayerController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addPlayer(PlayerRequest playerRequest) {
        personnelService.addPlayer(playerRequest);
        return ResponseEntity.ok().body(200);
    }

    @GetMapping("/find")
    public ResponseEntity<PlayersResponse> findPlayer() {

    }

}
