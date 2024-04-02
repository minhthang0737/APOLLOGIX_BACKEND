package com.test.skill.assessment.system.payload.request;

import java.util.List;

import lombok.Data;

@Data
public class TestQuestionReq {
	private Long testId;
	private List<Long> questionIds;
}
