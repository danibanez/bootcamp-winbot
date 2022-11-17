package com.bot.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BootcampTask {
    private String name;
    @JsonProperty("puntos")
    private long score;
}
