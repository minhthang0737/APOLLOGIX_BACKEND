package com.test.skill.assessment.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.payload.request.UserReq;
import com.test.skill.assessment.system.services.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "USER")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public BaseResponse<?> getAllUser() {
		return BaseResponse.success(userService.findAll());
	}
	
	@PostMapping("/add")
	public BaseResponse<?> addUser(@RequestBody UserReq req) {
		return BaseResponse.success(userService.addUser(req));
	}
	
	@PutMapping("/update")
	public BaseResponse<?> updateUser(@RequestBody UserReq req) {
		return BaseResponse.success(userService.updateUser(req));
	}
	
	@DeleteMapping("/del/{userId}")
	public BaseResponse<?> deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return BaseResponse.success(null);
	}
}
