package com.github.krezovic.artemis.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
@SpringBootApplication
public class ArtemisNativeDemoApplication {

	@JmsListener(destination = "METADATA")
	void listen(String message) {
		log.info("Received message {}", message);
	}

	public static void main(String[] args) {
		SpringApplication.run(ArtemisNativeDemoApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	void onApplicationReady(ApplicationReadyEvent event) {
		var jmsTemplate = event.getApplicationContext().getBean(JmsTemplate.class);
		jmsTemplate.convertAndSend("METADATA", "Hello World");
	}
}
