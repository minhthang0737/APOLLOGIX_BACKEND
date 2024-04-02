package com.test.skill.assessment.system.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.TestQuestionEntity;



@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestionEntity, Long> {
	Optional<TestQuestionEntity> findByTestId(Long testId);
}
