package com.bot.bot.github.service;

import com.bot.bootcamp.dto.TeamData;
import com.bot.bootcamp.service.TelegramService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class GithubServiceImpl implements GithubService {
    @Override
    public String githubWebhookPush() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://raw.githubusercontent.com/danibanez/bootcampsolera/main/src/data/teamdata.json";

        ObjectMapper mapper = new ObjectMapper();
        TeamData bootcampTeams =
                mapper.readValue(restTemplate.getForObject(url, String.class), TeamData.class);

        log.info(bootcampTeams);
        return TelegramService.sendToTelegram(bootcampTeams);

    }


}
