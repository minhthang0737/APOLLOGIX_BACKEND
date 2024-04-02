package com.test.skill.assessment.system.payload.reponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionDTO {
	private Long id;
	private List<QuestionDTO> question;
}
