package com.test.skill.assessment.system.model.entity;

import java.math.BigDecimal;

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
@Table(name = "test_result")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResultEntity {
	@Id
	@SequenceGenerator(name = "SEQ_GEN_RS", sequenceName = "RS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_RS")
	@Column(name = "id_", nullable = false)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "test_id")
	private Long testId;
	
	@Column(name = "score")
	private BigDecimal score;
}