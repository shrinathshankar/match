package com.match.mmr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.match.mmr.model.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TeamDto {
    @JsonProperty("playerOne")
    private Player playerOne;
    @JsonProperty("playerTwo")
    private Player playerTwo;
    @JsonProperty("win")
    private boolean win;
}
