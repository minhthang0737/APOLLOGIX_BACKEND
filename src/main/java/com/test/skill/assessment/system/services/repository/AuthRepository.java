package com.test.skill.assessment.system.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.AuthEntity;


@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
	Optional<AuthEntity> findByEmail(String email);
}
