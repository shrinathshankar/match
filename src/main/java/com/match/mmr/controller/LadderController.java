package com.match.mmr.controller;

import com.match.mmr.model.entity.Ladder;
import com.match.mmr.model.request.LadderRequest;
import com.match.mmr.repository.LadderRepository;
import com.match.mmr.services.PersonnelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ladder")
public class LadderController {

    private LadderRepository ladderRepository;
    private PersonnelService personnelService;
    public LadderController(LadderRepository ladderRepository, PersonnelService personnelService) {
        this.ladderRepository = ladderRepository;
        this.personnelService = personnelService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createLadder(@RequestBody LadderRequest ladderRequest){
        personnelService.createLadder(ladderRequest);
    }
    @GetMapping
    public ResponseEntity<Ladder> getLadder(@RequestParam long id){
        Optional<Ladder> optionalLadder = ladderRepository.findById(id);
        return optionalLadder.map(ladder -> ResponseEntity.status(HttpStatus.OK).body(ladder)).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Ladder()));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Ladder>> getLadderList(){
        return ResponseEntity.status(HttpStatus.OK).body(ladderRepository.findAll());
    }
}
