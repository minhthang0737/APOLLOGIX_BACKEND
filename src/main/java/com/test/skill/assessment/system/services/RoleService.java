package com.test.skill.assessment.system.services;

import com.test.skill.assessment.system.model.entity.RolesEntity;

public interface RoleService {
	RolesEntity addRole(String name, String description);
	RolesEntity findByRoleId(Long roleId);
	RolesEntity findByRoleName(String roleName);
}
