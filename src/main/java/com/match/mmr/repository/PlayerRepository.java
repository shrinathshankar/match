package com.match.mmr.repository;

import com.match.mmr.model.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByName(String name);
    List<Player> findByNameAndUsername(String name, String username);

}
