package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.TestEntity;
import com.test.skill.assessment.system.model.entity.TestQuestionEntity;
import com.test.skill.assessment.system.payload.reponse.TestQuestionDTO;
import com.test.skill.assessment.system.payload.reponse.TestResultDTO;
import com.test.skill.assessment.system.payload.request.TestQuestionReq;
import com.test.skill.assessment.system.payload.request.TestReq;
import com.test.skill.assessment.system.payload.request.TestSubmitReq;

public interface TestService {
	TestEntity add(TestReq req);
	
	TestQuestionEntity addQuestion(TestQuestionReq req);
	
	List<TestQuestionDTO> findAll();
	
	TestQuestionDTO findById(Long testId);
	
	TestEntity findByTestId(Long testId);

	TestResultDTO submit(TestSubmitReq req);
}
