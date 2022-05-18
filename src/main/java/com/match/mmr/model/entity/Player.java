package com.match.mmr.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "player_data")
@Entity
public class Player {

    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private Double rating;
    @ManyToOne
    private User user;

    @ManyToMany
    private List<Ladder> ladders;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long id;

    public Player(String name, Double rating, User user) {
        this.name = name;
        this.rating = rating;
        this.user = user;

    }
}
