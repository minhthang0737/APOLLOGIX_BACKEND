package com.test.skill.assessment.system.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.RolesEntity;
import com.test.skill.assessment.system.model.entity.UserEntity;
import com.test.skill.assessment.system.payload.request.UserReq;
import com.test.skill.assessment.system.services.RoleService;
import com.test.skill.assessment.system.services.UserRoleService;
import com.test.skill.assessment.system.services.UserService;
import com.test.skill.assessment.system.services.repository.UserRepository;
import com.test.skill.assessment.system.services.util.ServicesConverge;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Value("${startup.teacher.email}")
	private String emailStartup;
	
	@Value("${startup.teacher.password}")
	private String pwStartup;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserEntity findByUsernameOrEmail(String username, String email) {
		return userRepo.findByUsernameOrEmail(username, email).orElse(null);
	}
	@Override
	public List<UserEntity> findAll() {
		return userRepo.findAll();
	}

	@Override
	public void createUserStartUp() {
		List<UserEntity> users = findAll();
		if (users.isEmpty()) {
			UserEntity user = createUserEntity(emailStartup, pwStartup, emailStartup, emailStartup);
			if (user != null)
			log.info("createUserStartUp is success with email " + emailStartup);
		}
	}
	
	@Override
	public UserEntity createUserEntity(String username, String password, String email, String fullname) {
		UserEntity user = new UserEntity(null, username, ServicesConverge.getPasswordEncoder().encode(password), fullname, email, new Date(), null);
		return userRepo.save(user);
	}
	@Override
	public Boolean checkUser(String email, String password) {
		UserEntity user = findByUsernameOrEmail(email, email);
		if (user == null) throw new UsernameNotFoundException(email);
		return ServicesConverge.getPasswordEncoder().matches(password, user.getPassword());
	}
	
	@Override
	public UserEntity addUser(UserReq req) {
		UserEntity user = createUserEntity(req.getUsername(), req.getPassword(), req.getEmail(), req.getFullname());
		if (user != null) {
			RolesEntity role = roleService.findByRoleName(req.getRoleName());
			if (role != null)
			userRoleService.addUserRole(user.getUserId(), role.getRoleId());
		}
		return user;
	}
	
	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}
	
	@Override
	public UserEntity updateUser(UserReq req) {
		UserEntity user = userRepo.findById(req.getUserId()).orElse(null);
		if (user == null) throw new UsernameNotFoundException(req.getUserId().toString());
		user.setFullname(req.getFullname());
		user.setPassword(ServicesConverge.getPasswordEncoder().encode(req.getPassword()));
		user.setUsername(req.getUsername());
		if (req.getRoleName() != null) {
			RolesEntity role = roleService.findByRoleName(req.getRoleName());
			userRoleService.addUserRole(user.getUserId(), role.getRoleId());
		}
		return userRepo.save(user);
	}
	@Override
	public UserEntity findByUserId(Long userId) {
		return userRepo.findByUserId(userId).orElse(null);
	}
	
	
}
