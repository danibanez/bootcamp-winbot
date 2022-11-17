package com.restAws.restAws;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataparser.TeamDataParser;

@RestController
public class Controller {

	@Value("${telegram.token}")
	private String telegramToken;

	@Value("${telegram.sendmessage.url}")
	private String msgURL;

	@Value("${telegram.update.url}")
	private String updateURL;

	// HEROKU LINK: https://apirest-telegram-bot.herokuapp.com/data
	@SuppressWarnings("unchecked")
	@PostMapping(path = "/data")
	public String getDemoData(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) throws IOException {

		// Fetches the bot's message log
		JSONObject updateLog = URLreader.readJSonFromURL(updateURL);

		// Creates a set with the subscribed user's IDs
		HashSet<String> idList = new HashSet<>();
		Optional<JSONArray> entryList = updateLog.values().stream().findFirst();
		if (entryList.isPresent())
			entryList.get().stream().forEach(entry -> {
				// If the user entered the right command, they will be added to the ID set
				String id;
				String command = ((JSONObject) ((JSONObject) entry).get("message")).get("text").toString();
				if (command.equals("/start")) {
					id = ((JSONObject) ((JSONObject) ((JSONObject) entry).get("message")).get("from")).get("id")
							.toString();
					idList.add(id);
				} else if (command.equals("/stop")) {
					id = ((JSONObject) ((JSONObject) ((JSONObject) entry).get("message")).get("from")).get("id")
							.toString();
					idList.remove(id);
				}
			});

		// Fetch the win message and send it to each user
		SendMessage sendMessage = new SendMessage();
		String winnerMessage = TeamDataParser.createWinnerMessageString(payload);
		idList.stream()
				.forEach(uniqueId -> sendMessage.sendThroughController(winnerMessage, msgURL, telegramToken, uniqueId));

		return winnerMessage;
	}
}
