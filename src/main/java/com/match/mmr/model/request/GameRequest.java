package com.match.mmr.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.match.mmr.model.TeamDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameRequest {

    @JsonProperty("teams")
    private List<TeamDto> teams;
}
