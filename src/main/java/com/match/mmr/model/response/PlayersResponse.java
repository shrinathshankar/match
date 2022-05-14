package com.match.mmr.model.response;

import com.match.mmr.model.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayersResponse {
    List<Player> players;
}
