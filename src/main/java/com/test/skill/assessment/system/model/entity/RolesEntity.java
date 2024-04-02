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
@Table(name = "role_")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesEntity {
	
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "ROLE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	@Column(name = "role_id", nullable = false)
	private Long roleId;
	
	@Column(name = "role_name", nullable = false)
	private String roleName;
	
	@Column(name = "description")
	private String description;
}
