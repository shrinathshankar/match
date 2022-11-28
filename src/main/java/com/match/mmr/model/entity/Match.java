package com.match.mmr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "matches")
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

    @Column(name = "timestamp")
    private String timestamp;

    @ManyToOne
    private Team winner;

    public Match(Team team1, Team team2, Team team3, String timestamp, Team winner) {
        this.team1 = team1;
        this.team2 = team2;
        this.team3 = team3;
        this.timestamp = timestamp;
        this.winner = winner;
    }
}
