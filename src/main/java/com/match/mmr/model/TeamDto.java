package com.match.mmr.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TeamDto {
    @JsonProperty("playerOne")
    private String playerOne;
    @JsonProperty("playerTwo")
    private String playerTwo;
    @JsonProperty("win")
    private boolean win;
}
