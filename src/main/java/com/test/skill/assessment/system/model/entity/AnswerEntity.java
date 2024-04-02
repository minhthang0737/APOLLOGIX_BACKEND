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
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerEntity {
	@Id
	@SequenceGenerator(name = "SEQ_GEN_AN", sequenceName = "AN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_AN")
	@Column(name = "id_", nullable = false)
	private Long id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "correct")
	private Boolean correct;
	
	@Column(name = "question_id")
	private Long questionId;
}
