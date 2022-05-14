package com.match.mmr.model.request;

import com.match.mmr.model.Team;
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
