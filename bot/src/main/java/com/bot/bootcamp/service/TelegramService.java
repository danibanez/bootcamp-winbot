package com.bot.bootcamp.service;

import com.bot.bootcamp.dto.TeamData;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@Log4j2
@Service
@NoArgsConstructor
public class TelegramService {

    public static String sendToTelegram(TeamData bootcampTeams) {
        final String[] teamWinner = {""};
        final long[] highestScore = {0};
        AtomicReference<Boolean> empate = new AtomicReference<>(false);
        bootcampTeams.getTeamData().forEach(team -> {
            final AtomicLong[] totalAct = {new AtomicLong()};
            team.getActivities().forEach(bootcampTask -> {
                totalAct[0].addAndGet(bootcampTask.getScore());
                if (highestScore[0] < totalAct[0].get()) {
                    highestScore[0] = totalAct[0].get();
                    teamWinner[0] = team.getName();
                } else if (highestScore[0] == totalAct[0].get()) {
                    empate.set(true);
                    teamWinner[0] += team.getName();
                }
            });
        });
        if (Boolean.TRUE.equals(empate.get())) {
            teamWinner[0] = "There is a tie with " + highestScore[0] + " points! The winners are " + teamWinner[0] + " and " + teamWinner[0];
        } else {
            teamWinner[0] = teamWinner[0] + " with " + highestScore[0] + " points!";
        }

        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

        String apiToken = "5647366243:AAF0qUIjd-GD4gzF5X5XpSeVoqXx4GUg8rE"; //Input the token of the bot.

        String chatId = "-1001839904443"; // Input the chatId.

        String text = "The team with most points is..." + teamWinner[0];
        log.info(text);
        urlString = String.format(urlString, apiToken, chatId, text);

        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
