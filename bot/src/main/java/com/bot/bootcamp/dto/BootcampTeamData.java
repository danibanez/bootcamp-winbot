package com.bot.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BootcampTeamData {
    private long id;
    private String name;
    @JsonProperty("actividades")
    private List<BootcampTask> activities;
}
