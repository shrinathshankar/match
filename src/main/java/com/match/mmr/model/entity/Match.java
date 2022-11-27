package com.match.mmr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {

    @Id
    @Column(name = "match_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;
    @ManyToOne
    private Team team3;

    @ManyToOne
    private Team winner;

}
