package com.test.skill.assessment.system.payload.reponse;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class TestHistoryDTO {
	private Long testId;
	private String name;
	private String description;
	private BigDecimal score;
	private List<QuestionDTO> question;
}
