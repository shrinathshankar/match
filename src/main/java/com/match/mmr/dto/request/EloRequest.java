package com.match.mmr.dto.request;

import com.match.mmr.dto.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EloRequest {

    private Team one;
    private Team two;
    private String winner;

}
