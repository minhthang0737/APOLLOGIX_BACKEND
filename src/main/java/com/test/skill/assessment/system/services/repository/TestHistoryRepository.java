package com.test.skill.assessment.system.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.TestHistoryEntity;
import java.util.List;


@Repository
public interface TestHistoryRepository extends JpaRepository<TestHistoryEntity, Long> {
	List<TestHistoryEntity> findByTestResultId(Long testResultId);
	TestHistoryEntity findByTestResultIdAndQuestionId(Long testResultId, Long questionId);
}
