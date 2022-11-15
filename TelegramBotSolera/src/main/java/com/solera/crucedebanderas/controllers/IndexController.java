package com.solera.crucedebanderas.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.solera.crucedebanderas.methods.SendMessage;

@RestController
public class IndexController {
	
	@Value("${telegram.token}")
	private String telegramToken;
	
	@Value("${telegram.id}")
	private String id;
	
	@Value("${telegram.sendmessage.url}")
	private String url;
	
	@GetMapping("/test")
	private String indexController() {
		String message = "Hola desde el controlador";
		SendMessage sendMessage = new SendMessage();
		sendMessage.sendThroughController(message, url, telegramToken, id);
		System.out.println(url + telegramToken + id);
		return message;
		
	}

}
