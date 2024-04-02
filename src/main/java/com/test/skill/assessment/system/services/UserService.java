package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.UserEntity;
import com.test.skill.assessment.system.payload.request.UserReq;

public interface UserService {
	UserEntity findByUsernameOrEmail(String username, String email);
	
	UserEntity findByUserId(Long userId);
	
	List<UserEntity> findAll();
	
	void createUserStartUp();
	
	UserEntity createUserEntity(String username, String password, String email, String fullname);
	
	Boolean checkUser(String email, String password);

	UserEntity addUser(UserReq req);
	
	void deleteUser(Long userId);
	
	UserEntity updateUser(UserReq req);
}
