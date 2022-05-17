package com.match.mmr.model;

import com.match.mmr.model.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Team {

    private Player playerOne;
    private Player playerTwo;
    private boolean win;
}
