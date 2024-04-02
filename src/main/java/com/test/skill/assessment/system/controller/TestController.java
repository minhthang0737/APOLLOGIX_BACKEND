package com.test.skill.assessment.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.payload.request.TestQuestionReq;
import com.test.skill.assessment.system.payload.request.TestReq;
import com.test.skill.assessment.system.payload.request.TestSubmitReq;
import com.test.skill.assessment.system.services.TestService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "TEST")
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@PostMapping("/add")
	public BaseResponse<?> addTest(@RequestBody TestReq req) {
		return BaseResponse.success(testService.add(req));
	}
	
	@PostMapping("/add-question")
	public BaseResponse<?> addQuestion(@RequestBody TestQuestionReq req) {
		return BaseResponse.success(testService.addQuestion(req));
	}
	
	@GetMapping("/list")
	public BaseResponse<?> getTests() {
		return BaseResponse.success(testService.findAll());
	}
	
	@GetMapping("/detail/{id}")
	public BaseResponse<?> getTest(@PathVariable("id") Long id) {
		return BaseResponse.success(testService.findById(id));
	}
	
	@PostMapping("/submit")
	public BaseResponse<?> submit(@RequestBody TestSubmitReq req) {
		return BaseResponse.success(testService.submit(req));
	}
	
}