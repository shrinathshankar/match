package com.match.mmr.repository;

import com.match.mmr.model.entity.Player;
import com.match.mmr.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByName(String name);
    List<Player> findByNameAndUser(String name, User user);

}
