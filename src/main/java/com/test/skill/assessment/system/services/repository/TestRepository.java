package com.test.skill.assessment.system.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.TestEntity;



@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
	Optional<TestEntity> findById(Long id);
}
