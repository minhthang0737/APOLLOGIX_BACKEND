package com.test.skill.assessment.system.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.TestResultEntity;
import java.util.List;


@Repository
public interface TestResultRepository extends JpaRepository<TestResultEntity, Long> {
	List<TestResultEntity> findByUserId(Long userId);
}
