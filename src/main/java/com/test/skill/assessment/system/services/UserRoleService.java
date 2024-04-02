package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.UserRoleEntity;

public interface UserRoleService {
	List<UserRoleEntity> findByUserId(Long userId);
	List<UserRoleEntity> findByRoleId(Long roleId);
	UserRoleEntity addUserRole(Long userId, Long roleId);
	UserRoleEntity updateUserRole(Long userId, Long roleId);
}
