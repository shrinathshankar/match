package com.match.mmr.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "player_data")
public class Player {

    @Column(name = "name")
    private String name;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "rating")
    private Double rating;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long id;

    public Player(String name, String username, String password, Double rating) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.rating = rating;
    }
}
