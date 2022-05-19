package com.match.mmr.services;

import com.google.common.collect.ImmutableList;
import com.match.mmr.model.TeamDto;
import com.match.mmr.model.entity.*;
import com.match.mmr.model.request.GameRequest;
import com.match.mmr.model.request.LadderRequest;
import com.match.mmr.model.request.PlayerRequest;
import com.match.mmr.model.request.UserRequest;
import com.match.mmr.repository.MatchRepository;
import com.match.mmr.repository.PlayerRepository;
import com.match.mmr.repository.TeamRepository;
import com.match.mmr.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.match.mmr.services.Calculator.changeInRating;
import static com.match.mmr.services.Calculator.rating;

@Service
@Slf4j
public class PersonnelService {

    private Double DEFAULT_RATING = 1000.0;

    private PlayerRepository playerRepository;
    private UserRepository userRepository;
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private ModelMapper modelMapper;

    public PersonnelService(PlayerRepository playerRepository, UserRepository userRepository,
                            MatchRepository matchRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Team> calculateTeams(List<String> teamRequest) {
        List<Player> players = new ArrayList<>();
        teamRequest.forEach(player -> players.add(playerRepository.findByName(player)));
        List<Team> teams = new ArrayList<>();
        players.sort(Comparator.comparing(Player::getRating));
        for (int i = 0; i < players.size()/2; i++) {
            Team team = new Team(players.get(i), players.get(players.size() - 1 - i));
            teams.add(team);
            teamRepository.save(team);
        }
            return teams;
    }

    public void newRating(List<TeamDto> teams) {

        double change = changeInRating(teams.get(0), teams.get(1));
        teams.forEach(team -> {
            team.getPlayerOne().setRating(rating(team.getPlayerOne().getRating(), change, team.isWin()));
            team.getPlayerTwo().setRating(rating(team.getPlayerTwo().getRating(), change, team.isWin()));
            playerRepository.save(modelMapper.map(team.getPlayerOne(), Player.class));
            playerRepository.save(modelMapper.map(team.getPlayerTwo(), Player.class));
        });

    }

    public void addPlayer(PlayerRequest playerRequest) {
        Player player = new Player(playerRequest.getName(), DEFAULT_RATING, playerRequest.getUser());
        playerRepository.save(player);
    }

    public List<Player> getPlayer(PlayerRequest request) {
        return playerRepository.findByNameAndUser(request.getName(), request.getUser());
    }

    public List<Player> getAll() {
        return ImmutableList.copyOf(playerRepository.findAll().iterator());
    }

    public boolean addUser(UserRequest userRequest) {
        try {
            userRepository.save(modelMapper.map(userRequest, User.class));
        } catch (Exception e) {
            log.error("{} was not unique", userRequest);
            log.error("error {}", Arrays.toString(e.getStackTrace()));
            return false;
        }
        return true;
    }

    public void addMatch(GameRequest gameRequest) {
        matchRepository.save(modelMapper.map(gameRequest, Match.class));
    }

    public void createLadder(LadderRequest ladderRequest) {
        Ladder ladder = new Ladder();
        ladder.setOwner(userRepository.findByUsername(ladderRequest.getUsername()));
        List<Player> players = new ArrayList<>();
        ladderRequest.getPlayerNames().forEach(name ->
                players.add(new Player(name, DEFAULT_RATING)));
        ladder.setPlayers(players);
    }
}
