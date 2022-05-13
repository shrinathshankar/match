package com.match.mmr.dto.response;

import com.match.mmr.dto.Player;
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
