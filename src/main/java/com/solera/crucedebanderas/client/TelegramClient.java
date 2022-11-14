package com.solera.crucedebanderas.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.solera.crucedebanderas.methods.SendMessage;

public class TelegramClient {
	
	public static void main(String[] args) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.test();
	}
	


}
