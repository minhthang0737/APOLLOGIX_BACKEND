package com.test.skill.assessment.system.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.UserRoleEntity;
import com.test.skill.assessment.system.model.entity.id.UserRoleId;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, UserRoleId> {
	List<UserRoleEntity> findByUserId(Long userId);
	List<UserRoleEntity> findByRoleId(Long roleId);
}
