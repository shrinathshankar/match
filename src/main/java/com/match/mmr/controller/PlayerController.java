package com.match.mmr.controller;

import com.match.mmr.model.request.PlayerRequest;
import com.match.mmr.model.response.PlayersResponse;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PersonnelService personnelService;

    public PlayerController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addPlayer(@RequestBody PlayerRequest playerRequest) {
        personnelService.addPlayer(playerRequest);
        return ResponseEntity.ok().body(200);
    }

    @GetMapping("/find")
    public ResponseEntity<PlayersResponse> findPlayer(@RequestBody PlayerRequest playerRequest) {
        return ResponseEntity.ok().body(new PlayersResponse(personnelService.getPlayer(playerRequest)));
    }

}
