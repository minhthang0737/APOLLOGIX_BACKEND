package com.test.skill.assessment.system.payload.request;

import lombok.Data;

@Data
public class LogInReq {
	private String email;
	private String password;
}
