package com.match.mmr.repository;

import com.match.mmr.model.entity.Player;
import com.match.mmr.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByPlayerOne(Player one);
    List<Team> findByPlayerTwo(Player one);
}
