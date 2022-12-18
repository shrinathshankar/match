package com.match.mmr.repository;

import com.match.mmr.model.entity.Ladder;
import com.match.mmr.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LadderRepository extends JpaRepository<Ladder, Long> {
    Optional<List<Ladder>> findByOwner(User owner);
}
