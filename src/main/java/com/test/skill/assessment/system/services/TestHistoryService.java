package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.TestHistoryEntity;
import com.test.skill.assessment.system.payload.reponse.TestHistoryDTO;

public interface TestHistoryService {

	List<TestHistoryEntity> addAll(List<TestHistoryEntity> entitys);
	TestHistoryDTO getTestHistoryService(Long testResultId);
}
