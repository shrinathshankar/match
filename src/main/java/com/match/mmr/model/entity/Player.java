package com.match.mmr.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "players")
@Entity
public class Player {

    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne
    private User user;

    @Column(name = "wins")
    private int wins;
    @Column(name = "losses")
    private int losses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long id;

    public Player(String name, Double rating, int wins, int losses) {
        this.name = name;
        this.rating = rating;
        this.wins = wins;
        this.losses = losses;
    }

    public Player(String name, Double rating, User user) {
        this.name = name;
        this.rating = rating;
        this.user = user;
    }
    public Player(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }
}
