package com.test.skill.assessment.system.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.TestEntity;
import com.test.skill.assessment.system.model.entity.TestResultEntity;
import com.test.skill.assessment.system.model.entity.UserEntity;
import com.test.skill.assessment.system.payload.reponse.TestHistoryDTO;
import com.test.skill.assessment.system.payload.reponse.TestResultDetailDTO;
import com.test.skill.assessment.system.services.TestResultService;
import com.test.skill.assessment.system.services.UserService;
import com.test.skill.assessment.system.services.repository.TestResultRepository;
import com.test.skill.assessment.system.services.util.ServicesConverge;

@Service
public class TestResultServiceImpl implements TestResultService {
	@Autowired
	private TestResultRepository repository;
	
	@Autowired
	private UserService userService;

	@Override
	public TestResultEntity save(TestResultEntity test) {
		return repository.save(test);
	}

	@Override
	public List<TestResultDetailDTO> findAll() {
		List<TestResultDetailDTO> dots = new ArrayList<>();
		List<TestResultEntity> entitys = repository.findAll();
		if (!entitys.isEmpty()) {
			for (TestResultEntity testResultEntity : entitys) {
				TestResultDetailDTO item = getTestResultDTO(testResultEntity);
				dots.add(item);
			}
		}
		return dots;
	}

	private TestResultDetailDTO getTestResultDTO(TestResultEntity testResultEntity) {
		TestEntity testEntity = ServicesConverge.getTestService().findByTestId(testResultEntity.getTestId());
		TestResultDetailDTO item = new TestResultDetailDTO();
		item.setId(testResultEntity.getId());
		item.setTestId(testEntity.getId());
		item.setDescription(testEntity.getDescription());
		item.setName(testEntity.getName());
		item.setScore(testResultEntity.getScore());
		item.setUserId(testResultEntity.getUserId());
		UserEntity user = userService.findByUserId(testResultEntity.getUserId());
		item.setEmail(user.getEmail());
		return item;
	}

	@Override
	public TestResultDetailDTO getTestResultById(Long id) {
		TestResultEntity entity = repository.findById(id).orElse(null);
		return getTestResultDTO(entity);
	}

	@Override
	public List<TestResultDetailDTO> getTestResultByUserId(Long userId) {
		List<TestResultDetailDTO> dots = new ArrayList<>();
		List<TestResultEntity> entitys = repository.findByUserId(userId);
		if (!entitys.isEmpty()) {
			for (TestResultEntity testResultEntity : entitys) {
				TestResultDetailDTO item = getTestResultDTO(testResultEntity);
				dots.add(item);
			}
		}
		return dots;
	}

	@Override
	public TestHistoryDTO getTestHistory(Long testResult) {
		return null;
	}
	
	
}
