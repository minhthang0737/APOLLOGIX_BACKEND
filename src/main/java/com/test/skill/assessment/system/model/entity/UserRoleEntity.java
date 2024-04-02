package com.test.skill.assessment.system.model.entity;

import com.test.skill.assessment.system.model.entity.id.UserRoleId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserRoleId.class)
public class UserRoleEntity {
	
	@Id
	@Column(name = "user_id")
	private Long userId;
	
	@Id
	@Column(name = "role_id")
	private Long roleId;
	
}
