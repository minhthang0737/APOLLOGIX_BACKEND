package com.test.skill.assessment.system.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.RolesEntity;
import com.test.skill.assessment.system.services.RoleService;
import com.test.skill.assessment.system.services.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	@Override
	public RolesEntity addRole(String name, String description) {
		return repo.save(new RolesEntity(null, StringUtils.upperCase(name), description));
	}

	@Override
	public RolesEntity findByRoleId(Long roleId) {
		return repo.findByRoleId(roleId).orElse(null);
	}

	@Override
	public RolesEntity findByRoleName(String roleName) {
		return repo.findByRoleName(roleName).orElse(null);
	}
}
