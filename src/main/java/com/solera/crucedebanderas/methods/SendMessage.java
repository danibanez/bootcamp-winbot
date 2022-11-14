package com.solera.crucedebanderas.methods;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:application.properties")
public class SendMessage {
	// TODO no pilla los valores
	@Value("${telegram.token}")
	private String telegramToken;
	
	@Value("${telegram.id}")
	private String id;
	
	@Value("${telegram.message.updatedRepo}")
	private String updatedRepoMessage;
	
	@Value("${telegram.sendmessage.url}")
	private String url;
	
	@Bean    
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
	}
	
	public SendMessage() {
	}
	
	public void send(String message) {
		url = String.format(url, telegramToken, id, message);
		try {
			URL urlSend = new URL(url);
			URLConnection urlConnection = urlSend.openConnection();
			InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String test() {
		return telegramToken;
	}
}
