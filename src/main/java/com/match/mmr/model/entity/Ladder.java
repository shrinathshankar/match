package com.match.mmr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ladders")
public class Ladder {

    @ManyToOne
    private User owner;// only the owner can enter match details and add players
    @ManyToMany
    private List<Player> players;// players can be added without users but if a user has the id and name of the player,
    // then they can claim the player as one of theirs, and the player will be linked to the user
    @OneToMany
    private List<Match> matches;
    @Id
    @Column(name = "ladder_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ladderId;

    @Column(name = "name")
    private String name;

}
