package com.test.skill.assessment.system.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.TestQuestionEntity;
import com.test.skill.assessment.system.payload.request.TestQuestionReq;
import com.test.skill.assessment.system.services.TestQuestionService;
import com.test.skill.assessment.system.services.repository.TestQuestionRepository;

@Service
public class TestQuestionServiceImpl implements TestQuestionService {
	@Autowired
	private TestQuestionRepository repo;
	@Override
	public TestQuestionEntity addTestQuestion(TestQuestionReq req) {
		return repo.save(new TestQuestionEntity(null, req.getTestId(), StringUtils.join(req.getQuestionIds(), ",")));
	}
	@Override
	public TestQuestionEntity findByTestId(Long testId) {
		return repo.findByTestId(testId).orElse(null);
	}

}
