package com.test.skill.assessment.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.payload.request.LogInReq;
import com.test.skill.assessment.system.services.AuthenticationService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "AUTH")
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
	
private final AuthenticationService authService;
	
	@PostMapping("/login")
	public BaseResponse<?> getToken(@RequestBody LogInReq logInREq) {
		return BaseResponse.success(authService.getToken(logInREq.getEmail(), logInREq.getPassword()));
	}
	
	@PostMapping("/logout")
	public BaseResponse<?> logOut() {
		return BaseResponse.success(authService.logOut());
	}
}
