package com.match.mmr.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePlayerRequest {

    private String name;
    private String ladderId;
}
