package com.test.skill.assessment.system.services.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.skill.assessment.system.configuration.ApplicationContextProvider;
import com.test.skill.assessment.system.services.AuthenticationService;
import com.test.skill.assessment.system.services.TestService;

public class ServicesConverge {
	
	public static <T> T getService(Class<T> requiredType) {
		return ApplicationContextProvider.getApplicationContext().getBean(requiredType);
	}
	
	public static PasswordEncoder getPasswordEncoder() {
		return getService(PasswordEncoder.class);
	}
	
	public static AuthenticationService getAuthenticationService() {
		return getService(AuthenticationService.class);
	}
	
	public static TestService getTestService() {
		return getService(TestService.class);
	}
}
