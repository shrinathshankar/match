package com.match.mmr.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.match.mmr.model.entity.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    @NotNull
    @JsonProperty("name")
    private String name;
    @JsonProperty("user")
    private User user;
}
