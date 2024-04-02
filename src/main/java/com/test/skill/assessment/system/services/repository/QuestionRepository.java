package com.test.skill.assessment.system.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.QuestionEntity;


@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
