package com.solera.crucedebanderas.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
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
	
	private ArrayList<String> List_ID=new ArrayList<String>();
	
	@GetMapping("/test")
	private String indexController() throws IOException {
		String message = "Hola desde el controlador";
		SendMessage sendMessage = new SendMessage();
	;
		URL api=new URL("https://api.telegram.org/bot5760285754:AAHr400bKmjIKigKUdiKmu0zGzGg8bA55K8/getUpdates");
		
		List_ID.add("5404275146");
		List_ID.add("732904121");
		
		for(String id2 :List_ID) {
			sendMessage.sendThroughController(message, url, telegramToken, id2);
			System.out.println(url + telegramToken + id2);
		    }
		
		return message;
		
	}

}
