package com.test.skill.assessment.system.payload.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
	private Long id;
	private String content;
	private Boolean choose;
}
