package com.match.mmr.services;

import com.match.mmr.dto.Player;
import com.match.mmr.dto.Team;
import com.match.mmr.dto.request.PlayerRequest;
import com.match.mmr.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PersonnelService {

    private Double DEFAULT_RATING = 1000.0;

    private PlayerRepository playerRepository;

    public PersonnelService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Team> calculateTeams(List<String> teamRequest) {
        List<Player> players = new ArrayList<>();
        teamRequest.forEach(player -> players.add(playerRepository.findByName(player)));
        List<Team> teams = new ArrayList<>();
        players.sort(Comparator.comparing(Player::getRating));
        for (int i = 0; i < players.size()/2; i++) {
            teams.add(new Team(players.get(i), players.get(players.size() - 1 - i)));
        }
            return teams;
    }

    public void addPlayer(PlayerRequest playerRequest) {
        Player player = new Player(playerRequest.getName(), playerRequest.getUsername(), playerRequest.getPassword(), DEFAULT_RATING);
        playerRepository.save(player);
    }

    public List<Player> getPlayer(PlayerRequest request) {
        return playerRepository.findByNameAndUsername(request.getName(), request.getUsername());
    }
}
