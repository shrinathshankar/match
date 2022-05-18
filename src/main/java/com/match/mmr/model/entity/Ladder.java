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
public class Ladder {

    @ManyToMany
    private List<Player> players;
    @OneToMany
    private List<Match> matches;
    @Id
    @Column(name = "ladder_id")
    private Long ladderId;

}
