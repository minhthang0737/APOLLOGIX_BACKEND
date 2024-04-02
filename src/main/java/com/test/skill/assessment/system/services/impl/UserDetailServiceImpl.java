package com.test.skill.assessment.system.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.RolesEntity;
import com.test.skill.assessment.system.model.entity.UserEntity;
import com.test.skill.assessment.system.model.entity.UserRoleEntity;
import com.test.skill.assessment.system.model.entity.user.UserInfoDetail;
import com.test.skill.assessment.system.services.RoleService;
import com.test.skill.assessment.system.services.UserRoleService;
import com.test.skill.assessment.system.services.UserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userService.findByUsernameOrEmail(username, username);
		if (userEntity == null) throw new UsernameNotFoundException(username);
		List<UserRoleEntity> userRoles = userRoleService.findByUserId(userEntity.getUserId());
		Set<GrantedAuthority> authors = new HashSet<GrantedAuthority>();
		convertRole(userRoles, authors);
		return new UserInfoDetail(userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword(), authors);
	}

	private void convertRole(List<UserRoleEntity> userRoles, Set<GrantedAuthority> authors) {
		if (!userRoles.isEmpty()) {
			for (UserRoleEntity userRole : userRoles) {
				RolesEntity role = roleService.findByRoleId(userRole.getRoleId());
				if (role != null) {
					authors.add(new SimpleGrantedAuthority(role.getRoleName()));
				}
			}
		}
	}

}
