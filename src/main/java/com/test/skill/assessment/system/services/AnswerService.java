package com.test.skill.assessment.system.services;

import java.util.List;

import com.test.skill.assessment.system.model.entity.AnswerEntity;
import com.test.skill.assessment.system.payload.request.AnswerReq;

public interface AnswerService {
	AnswerEntity add(AnswerReq req);
	AnswerEntity findById(Long answerId);
	List<AnswerEntity> findByQuestionId(Long questionId);
}
