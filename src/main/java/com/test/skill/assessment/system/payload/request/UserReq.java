package com.test.skill.assessment.system.payload.request;

import lombok.Data;

@Data
public class UserReq {
	private Long userId;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String roleName;
}
