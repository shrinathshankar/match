package com.match.mmr;

import com.match.mmr.model.entity.Match;
import com.match.mmr.model.entity.Player;
import com.match.mmr.model.entity.Team;
import com.match.mmr.repository.*;
import com.opencsv.CSVReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
			FileReader leaderboard = new FileReader("./src/main/resources/hf_leaderboard.csv");
			CSVReader csvLeaderboard = new CSVReader(leaderboard);
			csvLeaderboard.forEach(person -> {
				Player player = new Player(person[0], Double.parseDouble(person[1]), Integer.parseInt(person[2]), Integer.parseInt(person[3]));
				playerRepository.save(player);
			});

			FileReader matchHistory = new FileReader("./src/main/resources/hf_match_history.csv");
			CSVReader csvMatchHistory = new CSVReader(matchHistory);
			csvMatchHistory.forEach(match -> {
				Player oneTeamOne = playerRepository.findByName(match[1]);
				Player twoTeamOne = playerRepository.findByName(match[2]);
				Team one = new Team(oneTeamOne, twoTeamOne);
				teamRepository.save(one);

				Player oneTeamTwo = playerRepository.findByName(match[3]);
				Player twoTeamTwo = playerRepository.findByName(match[4]);
				Team two = new Team(oneTeamTwo, twoTeamTwo);
				teamRepository.save(two);

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
			});
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return "finished initialization";
	}

}
