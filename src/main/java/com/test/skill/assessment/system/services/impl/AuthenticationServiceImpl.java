package com.test.skill.assessment.system.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.AuthEntity;
import com.test.skill.assessment.system.model.entity.UserEntity;
import com.test.skill.assessment.system.model.entity.user.UserInfoDetail;
import com.test.skill.assessment.system.security.provider.JwtProvider;
import com.test.skill.assessment.system.services.AuthenticationService;
import com.test.skill.assessment.system.services.UserService;
import com.test.skill.assessment.system.services.repository.AuthRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private AuthRepository repo;
	
	@Override
	public String getToken(String email, String password) {
		UserEntity user = userService.findByUsernameOrEmail(email, email);
		if (!userService.checkUser(email, password)) throw new UsernameNotFoundException(email);
		String token = jwtProvider.generateToken(user.getEmail());
		AuthEntity auth = findByEmail(email);
		if (auth != null) {
			auth.setToken(token);
			auth = updateAuthen(auth);
		} else {
			auth = addAuthen(email, token);
		}
		return auth.getToken();
	}

	@Override
	public Boolean logOut() {
		UserInfoDetail user = (UserInfoDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		removeAuth(user.getUsername());
		return true;
	}
	
	@Override
	public AuthEntity findByEmail(String email) {
		return repo.findByEmail(email).orElse(null);
	}

	@Override
	public AuthEntity addAuthen(String email, String token) {
		return repo.save(new AuthEntity(null, email, token));
	}

	@Override
	public boolean isExist(String email) {
		return findByEmail(email) != null;
	}

	@Override
	public AuthEntity updateAuthen(AuthEntity auth) {
		return repo.save(auth);
	}

	@Override
	public void removeAuth(String email) {
		repo.delete(findByEmail(email));
	}
	
	@Override
	public Long getUserId() {
		UserInfoDetail user = (UserInfoDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user != null) {
			UserEntity entity = userService.findByUsernameOrEmail(user.getUsername(), user.getEmail());
			return entity.getUserId();
		}
		return null;
	}
}
