package com.test.skill.assessment.system.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.QuestionEntity;
import com.test.skill.assessment.system.payload.request.QuestionReq;
import com.test.skill.assessment.system.services.QuestionService;
import com.test.skill.assessment.system.services.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository repo;
	
	@Override
	public QuestionEntity add(QuestionReq req) {
		return repo.save(new QuestionEntity(null, req.getContent()));
	}

	@Override
	public QuestionEntity findById(Long id) {
		return repo.findById(id).orElse(null);
	}

}
