package com.test.skill.assessment.system.services;

import com.test.skill.assessment.system.model.entity.QuestionEntity;
import com.test.skill.assessment.system.payload.request.QuestionReq;

public interface QuestionService {
	QuestionEntity add(QuestionReq req);
	QuestionEntity findById(Long id);
}
