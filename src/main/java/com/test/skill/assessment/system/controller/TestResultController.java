package com.test.skill.assessment.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.skill.assessment.system.payload.BaseResponse;
import com.test.skill.assessment.system.services.TestHistoryService;
import com.test.skill.assessment.system.services.TestResultService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@Tag(name = "RESULT")
@RequestMapping("/result")
@AllArgsConstructor
public class TestResultController {
	@Autowired
	private TestResultService resultService;
	
	@Autowired
	private TestHistoryService testHistoryService;
	
	@GetMapping("/list")
	public BaseResponse<?> getList() {
		return BaseResponse.success(resultService.findAll());
	}
	
	@GetMapping("/{id}")
	public BaseResponse<?> getTestReulstById(@PathVariable("id") Long id) {
		return BaseResponse.success(resultService.getTestResultById(id));
	}
	
	@GetMapping("/user/{userId}")
	public BaseResponse<?> getTestReulstByUserId(@PathVariable("userId") Long userId) {
		return BaseResponse.success(resultService.getTestResultByUserId(userId));
	}
	
	@GetMapping("/history/{resultId}")
	public BaseResponse<?> getTestHistory(@PathVariable("resultId") Long resultId) {
		return BaseResponse.success(testHistoryService.getTestHistoryService(resultId));
	}
}
