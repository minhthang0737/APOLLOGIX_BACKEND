package com.test.skill.assessment.system.services;

import com.test.skill.assessment.system.model.entity.TestQuestionEntity;
import com.test.skill.assessment.system.payload.request.TestQuestionReq;

public interface TestQuestionService {
	TestQuestionEntity addTestQuestion(TestQuestionReq req);
	TestQuestionEntity findByTestId(Long testId);
}
