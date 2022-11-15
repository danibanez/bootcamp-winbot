package com.solera.crucedebanderas.methods;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RunAfterStartUp {
	
	@Value("${server.port}")
	private String port;
	
	@Value("${my.app.url}")
	private String url;
	
	@Value("${my.app.timeloop}")
	private Long loopLong;
	
	@EventListener(ApplicationReadyEvent.class)
	public void onStartup(){
		RestTemplate rt = new RestTemplate();
		
		try {
			while (true) {
				url = String.format(url, port);
				System.out.println("Sending message through the bot");
				rt.getForEntity(url, String.class);
				System.out.println(new Date());
			Thread.sleep(loopLong);}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
