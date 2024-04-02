package com.test.skill.assessment.system.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.AnswerEntity;
import java.util.List;



@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
	List<AnswerEntity> findByQuestionId(Long questionId);
}
