package com.test.skill.assessment.system.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authentication")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthEntity {
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "AUTH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@Column(name = "auth_id", nullable = false)
	private Long authId;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "token")
	private String token;
}
