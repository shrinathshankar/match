package com.match.mmr.repository;

import com.match.mmr.dto.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByName(String name);
}
