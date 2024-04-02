package com.test.skill.assessment.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.payload.request.RoleReq;
import com.test.skill.assessment.system.services.RoleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "ROLE")
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/add")
	public BaseResponse<?> addRole(@RequestBody RoleReq req) {
		return BaseResponse.success(roleService.addRole(req.getRoleName(), req.getRoleDescription()));
	}
}
