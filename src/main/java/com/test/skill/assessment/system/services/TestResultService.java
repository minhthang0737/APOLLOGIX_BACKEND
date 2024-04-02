package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.TestResultEntity;
import com.test.skill.assessment.system.payload.reponse.TestHistoryDTO;
import com.test.skill.assessment.system.payload.reponse.TestResultDetailDTO;

public interface TestResultService {

	TestResultEntity save(TestResultEntity test);
	List<TestResultDetailDTO> findAll();
	
	TestResultDetailDTO getTestResultById(Long id);
	List<TestResultDetailDTO> getTestResultByUserId(Long userId);
	
	TestHistoryDTO getTestHistory(Long testResult);
}
