package com.match.mmr.model.response;

import com.match.mmr.model.entity.Ladder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderResponse {
    List<Ladder> ladders;
}
