package com.match.mmr.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LadderRequest {

    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;

}
