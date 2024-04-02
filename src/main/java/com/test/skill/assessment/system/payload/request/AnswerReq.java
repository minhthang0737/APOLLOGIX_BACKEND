package com.test.skill.assessment.system.payload.request;

import lombok.Data;

@Data
public class AnswerReq {
	private String content;
	private Boolean correct;
	private Long questionId;
}
