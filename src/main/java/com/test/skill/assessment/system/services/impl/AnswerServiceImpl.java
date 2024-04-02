package com.test.skill.assessment.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.AnswerEntity;
import com.test.skill.assessment.system.payload.request.AnswerReq;
import com.test.skill.assessment.system.services.AnswerService;
import com.test.skill.assessment.system.services.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository repo;
	
	@Override
	public AnswerEntity add(AnswerReq req) {
		return repo.save(new AnswerEntity(null, req.getContent(), req.getCorrect(), req.getQuestionId()));
	}

	@Override
	public List<AnswerEntity> findByQuestionId(Long questionId) {
		return repo.findByQuestionId(questionId);
	}

	@Override
	public AnswerEntity findById(Long answerId) {
		return repo.findById(answerId).orElse(null);
	}

}
