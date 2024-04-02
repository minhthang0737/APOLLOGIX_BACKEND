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
@Table(name = "test_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestHistoryEntity {
	@Id
	@SequenceGenerator(name = "TH_ID_SEQ", sequenceName = "TH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TH_ID_SEQ")
	@Column(name = "id_", nullable = false)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "test_id")
	private Long testId;
	
	@Column(name = "question_id")
	private Long questionId;
	
	@Column(name = "answer_ids")
	private String answerIds;
	
	@Column(name = "test_result_id")
	private Long testResultId;
}