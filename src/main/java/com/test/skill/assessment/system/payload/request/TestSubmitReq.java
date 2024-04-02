package com.test.skill.assessment.system.payload.request;

import java.util.List;

import com.test.skill.assessment.system.payload.reponse.QuestionDTO;

import lombok.Data;

@Data
public class TestSubmitReq {
	private Long testId;
	private List<QuestionDTO> questionDTO;
}
