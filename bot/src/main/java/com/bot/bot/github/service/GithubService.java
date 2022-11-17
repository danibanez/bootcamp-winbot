package com.bot.bot.github.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface GithubService {
    String githubWebhookPush() throws JsonProcessingException;

}
