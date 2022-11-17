package com.bot.bot.github.controller;

import com.bot.bot.github.service.GithubService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @GetMapping("/github/teamdata")
    public String postBootcampTeamData() throws JsonProcessingException {
       return githubService.githubWebhookPush();
    }

}
