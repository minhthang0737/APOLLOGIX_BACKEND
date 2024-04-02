package com.test.skill.assessment.system.payload.reponse;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDTO {
	protected Long id;
	protected Long testId;
	protected BigDecimal score;
}
