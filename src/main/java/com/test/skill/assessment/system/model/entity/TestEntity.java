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
@Table(name = "test_")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
	@Id
	@SequenceGenerator(name = "SEQ_GEN_TEST", sequenceName = "TEST_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_TEST")
	@Column(name = "id_", nullable = false)
	private Long id;
	
	@Column(name = "name_", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
}
