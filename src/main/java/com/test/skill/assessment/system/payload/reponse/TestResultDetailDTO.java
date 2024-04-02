package com.test.skill.assessment.system.payload.reponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestResultDetailDTO extends TestResultDTO {
	private String name;
	private String description;
	private Long userId;
	private String email;
}
