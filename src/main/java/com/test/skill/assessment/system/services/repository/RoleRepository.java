package com.test.skill.assessment.system.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.skill.assessment.system.model.entity.RolesEntity;


@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
	Optional<RolesEntity> findByRoleName(String roleName);
	Optional<RolesEntity> findByRoleId(Long roleId);
}
