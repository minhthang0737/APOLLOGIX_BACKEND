package com.test.skill.assessment.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.UserRoleEntity;
import com.test.skill.assessment.system.services.UserRoleService;
import com.test.skill.assessment.system.services.repository.UserRoleRepository;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository repo;

	@Override
	public List<UserRoleEntity> findByUserId(Long userId) {
		return repo.findByUserId(userId);
	}

	@Override
	public List<UserRoleEntity> findByRoleId(Long roleId) {
		return repo.findByRoleId(roleId);
	}

	@Override
	public UserRoleEntity addUserRole(Long userId, Long roleId) {
		return repo.save(new UserRoleEntity(userId, roleId));
	}

	@Override
	public UserRoleEntity updateUserRole(Long userId, Long roleId) {
		List<UserRoleEntity> entitys = findByUserId(userId);
		if (!entitys.isEmpty()) {
			UserRoleEntity entity = entitys.get(0);
			entity.setRoleId(roleId);
			return repo.save(entity);
		}
		return null;
	}
	
	
	
	
}
