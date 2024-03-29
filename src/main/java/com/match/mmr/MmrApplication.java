package com.match.mmr;

import com.match.mmr.model.entity.*;
import com.match.mmr.repository.*;
import com.opencsv.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.hasText;


@EnableJpaAuditing
@SpringBootApplication
public class MmrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmrApplication.class, args);
	}

	@Bean
	public String init(LadderRepository ladderRepository, MatchRepository matchRepository,
					   PlayerRepository playerRepository, TeamRepository teamRepository, UserRepository userRepository) {

		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		try {
			Ladder ladder = new Ladder();
			List<Player> players = new ArrayList<>();
			List<Match> matches = new ArrayList<>();
			ladder.setName("Hand and Foot");

			FileReader leaderboard = new FileReader("./src/main/resources/hf_leaderboard.csv");
			CSVReader csvLeaderboard = new CSVReader(leaderboard);
			csvLeaderboard.forEach(person -> {
				Player player = new Player(person[0], Double.parseDouble(person[1]), Integer.parseInt(person[2]), Integer.parseInt(person[3]));
				playerRepository.save(player);
				players.add(player);
			});

			FileReader matchHistory = new FileReader("./src/main/resources/hf_match_history.csv");
			CSVReader csvMatchHistory = new CSVReader(matchHistory);
			csvMatchHistory.forEach(match -> {
				Player oneTeamOne = playerRepository.findByName(match[1]);
				Player twoTeamOne = playerRepository.findByName(match[2]);
				Team one;
				List<Team> teams = teamRepository.findByPlayerOne(oneTeamOne);
				teams.addAll(teamRepository.findByPlayerTwo(oneTeamOne));
				teams = teams.stream().filter( team -> team.getPlayerOne().getName().equals(twoTeamOne.getName())
						|| team.getPlayerTwo().getName().equals(twoTeamOne.getName()) )
						.collect(Collectors.toList());
				if (teams.isEmpty()) {
					 one = new Team(oneTeamOne, twoTeamOne);
					teamRepository.save(one);
				} else {
					one = teams.stream().findFirst().get();
				}

				Player oneTeamTwo = playerRepository.findByName(match[3]);
				Player twoTeamTwo = playerRepository.findByName(match[4]);
				Team two;
				List<Team> teamsTwo = teamRepository.findByPlayerOne(oneTeamTwo);
				teamsTwo.addAll(teamRepository.findByPlayerTwo(oneTeamTwo));
				teamsTwo= teamsTwo.stream().filter( team -> team.getPlayerOne().getName().equals(twoTeamTwo.getName())
								|| team.getPlayerTwo().getName().equals(twoTeamTwo.getName()) )
						.collect(Collectors.toList());
				if (teamsTwo.isEmpty()) {
					two = new Team(oneTeamTwo, twoTeamTwo);
					teamRepository.save(two);
				} else {
					two = teamsTwo.stream().findFirst().get();
				}

				Team three = null;
				if (hasText(match[5]) && hasText(match[6])) {
					Player oneTeamThree = playerRepository.findByName(match[5]);
					Player twoTeamThree = playerRepository.findByName(match[6]);
					three = new Team(oneTeamThree, twoTeamThree);
					teamRepository.save(three);

				}
				Team winner;
				String winnerName = match[7];
				if (winnerName.contains("1")) {
					winner = one;
				} else if (winnerName.contains("2")) {
					winner = two;
				} else {
					winner = three;
				}
				Match instance = new Match(one, two, three, match[0], winner);
				matchRepository.save(instance);
				matches.add(instance);
			});

			User user = new User();
			user.setEmail("default");
			user.setPassword("password");
			user.setUsername("Jimmy");
			userRepository.save(user);

			ladder.setOwner(user);
			ladder.setMatches(matches);
			ladder.setPlayers(players);

			ladderRepository.save(ladder);

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return "finished initialization";
	}



}
