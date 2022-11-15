package com.solera.crucedebanderas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class TelegramBotSoleraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramBotSoleraApplication.class, args);
	}

}
