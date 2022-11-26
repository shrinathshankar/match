package com.match.mmr.controller;

import com.match.mmr.model.request.GameRequest;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private PersonnelService personnelService;

    public MatchController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void addMatch(@RequestBody GameRequest gameRequest) {
        personnelService.addMatch(gameRequest);
    }
}
