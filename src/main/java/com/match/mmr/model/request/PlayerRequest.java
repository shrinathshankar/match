package com.match.mmr.model.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    @NotNull
    private String name;
    private String username;
    private String password;
}
