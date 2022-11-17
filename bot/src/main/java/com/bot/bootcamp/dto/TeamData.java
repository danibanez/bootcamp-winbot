package com.bot.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TeamData {
    @JsonProperty("teamdata")
    private List<BootcampTeamData> teamData;
}
