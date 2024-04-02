package com.test.skill.assessment.system.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.skill.assessment.system.model.entity.TestHistoryEntity;
import com.test.skill.assessment.system.payload.reponse.AnswerDTO;
import com.test.skill.assessment.system.payload.reponse.QuestionDTO;
import com.test.skill.assessment.system.payload.reponse.TestHistoryDTO;
import com.test.skill.assessment.system.payload.reponse.TestQuestionDTO;
import com.test.skill.assessment.system.payload.reponse.TestResultDetailDTO;
import com.test.skill.assessment.system.services.TestHistoryService;
import com.test.skill.assessment.system.services.TestResultService;
import com.test.skill.assessment.system.services.repository.TestHistoryRepository;
import com.test.skill.assessment.system.services.util.ServicesConverge;

@Service
public class TestHistoryServiceImpl implements TestHistoryService {
	
	@Autowired
	private TestHistoryRepository repo;
	
	@Autowired
	private TestResultService testResultService;
	
	
	@Override
	public List<TestHistoryEntity> addAll(List<TestHistoryEntity> entitys) {
		return repo.saveAll(entitys);
	}
	
	@Override
	public TestHistoryDTO getTestHistoryService(Long testResultId) {
		TestHistoryDTO dto = new TestHistoryDTO();
		TestResultDetailDTO resultService = testResultService.getTestResultById(testResultId);
		dto.setDescription(resultService.getDescription());
		dto.setName(resultService.getName());
		dto.setScore(resultService.getScore());
		dto.setTestId(resultService.getTestId());
		TestQuestionDTO testQuestionDTO = ServicesConverge.getTestService().findById(resultService.getTestId());
		List<QuestionDTO> questionDTOs = testQuestionDTO.getQuestion();
		for (QuestionDTO questionDTO : questionDTOs) {
			TestHistoryEntity historyEntity = repo.findByTestResultIdAndQuestionId(testResultId, questionDTO.getId());
			String[] answerIds = historyEntity.getAnswerIds().split(",");
			List<AnswerDTO> answerDTOs = questionDTO.getAnswers();
			for (AnswerDTO answerDTO : answerDTOs) {
				for (String answerId : answerIds) {
					if (Long.valueOf(answerId) == answerDTO.getId()) {
						answerDTO.setChoose(true);
					}
				}
			}
		}
		dto.setQuestion(questionDTOs);
		return dto;
	}
}
