package com.test.skill.assessment.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.payload.request.AnswerReq;
import com.test.skill.assessment.system.services.AnswerService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "ANSWER")
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/add")
	public BaseResponse<?> addRole(@RequestBody AnswerReq req) {
		return BaseResponse.success(answerService.add(req));
	}
}
