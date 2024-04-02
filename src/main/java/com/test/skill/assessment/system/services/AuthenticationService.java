package com.test.skill.assessment.system.services;

import com.test.skill.assessment.system.model.entity.AuthEntity;

public interface AuthenticationService {
	String getToken(String email, String password);
	
	Boolean logOut();
	
	AuthEntity findByEmail(String email);
	
	AuthEntity addAuthen(String email, String token);
	
	AuthEntity updateAuthen(AuthEntity auth);
	
	boolean isExist(String email);
	
	void removeAuth(String email);
	
	Long getUserId();
}
