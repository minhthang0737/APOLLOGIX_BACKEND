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
@Table(name = "test_question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestionEntity {
	@Id
	@SequenceGenerator(name = "SEQ_GEN_TQ", sequenceName = "TQ_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_TQ")
	@Column(name = "id_", nullable = false)
	private Long id;
	
	@Column(name = "test_id", nullable = false)
	private Long testId;
	
	@Column(name = "question_id", nullable = false)
	private String questionIds;
}
