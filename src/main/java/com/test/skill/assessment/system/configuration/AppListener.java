package com.test.skill.assessment.system.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import com.test.skill.assessment.system.services.UserService;

@Configuration
public class AppListener implements ApplicationListener<ApplicationStartedEvent> {
	@Autowired
	private UserService userService;
	
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		userService.createUserStartUp();
		System.out.println("App start success!");
	}
}
