package com.test.skill.assessment.system.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
	Optional<UserEntity> findByUsernameOrEmail(String username, String email);
	Optional<UserEntity> findByUserId(Long userId);
}
