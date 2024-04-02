package com.test.skill.assessment.system.payload.reponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
	private Long id;
	private String content;
	private List<AnswerDTO> answers;
}
