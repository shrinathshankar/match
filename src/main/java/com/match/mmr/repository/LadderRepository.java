package com.match.mmr.repository;

import com.match.mmr.model.entity.Ladder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LadderRepository extends JpaRepository<Ladder, Long> {
}
