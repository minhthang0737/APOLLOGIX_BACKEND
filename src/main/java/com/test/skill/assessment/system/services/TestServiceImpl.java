package com.test.skill.assessment.system.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.skill.assessment.system.model.entity.AnswerEntity;
import com.test.skill.assessment.system.model.entity.QuestionEntity;
import com.test.skill.assessment.system.model.entity.TestEntity;
import com.test.skill.assessment.system.model.entity.TestHistoryEntity;
import com.test.skill.assessment.system.model.entity.TestQuestionEntity;
import com.test.skill.assessment.system.model.entity.TestResultEntity;
import com.test.skill.assessment.system.payload.reponse.AnswerDTO;
import com.test.skill.assessment.system.payload.reponse.QuestionDTO;
import com.test.skill.assessment.system.payload.reponse.TestQuestionDTO;
import com.test.skill.assessment.system.payload.reponse.TestResultDTO;
import com.test.skill.assessment.system.payload.request.TestQuestionReq;
import com.test.skill.assessment.system.payload.request.TestReq;
import com.test.skill.assessment.system.payload.request.TestSubmitReq;
import com.test.skill.assessment.system.services.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository repo;
	
	@Autowired
	private TestQuestionService testQuestionService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TestResultService testResultService;
	
	@Autowired
	private TestHistoryService  historyService;
	
	@Override
	public TestEntity add(TestReq req) {
		return repo.save(new TestEntity(null, req.getName(), req.getDescription()));
	}
	@Override
	public TestQuestionEntity addQuestion(TestQuestionReq req) {
		return testQuestionService.addTestQuestion(req);
	}
	@Override
	public List<TestQuestionDTO> findAll() {
		List<TestQuestionDTO> dtos = new ArrayList<>();
		List<TestEntity> tests = repo.findAll();
		if (!tests.isEmpty()) {
			for (TestEntity testEntity : tests) {
				dtos.add(convertEntityToDTO(testEntity));
			}
		}
		return dtos;
	}
	private TestQuestionDTO convertEntityToDTO(TestEntity testEntity) {
		TestQuestionDTO dto = new TestQuestionDTO();
		TestQuestionEntity testQuestion = testQuestionService.findByTestId(testEntity.getId());
		String questionIds = testQuestion.getQuestionIds();
		dto.setId(testEntity.getId());
		List<QuestionDTO> questionDTOs = new ArrayList<>();
		if (questionIds == null || questionIds.isEmpty()) return dto;
		for (String questionId : StringUtils.split(questionIds, ",")) {
			QuestionEntity question = questionService.findById(Long.valueOf(questionId));
			if (question != null) {
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setId(question.getId());
				questionDTO.setContent(question.getContent());
				questionDTO.setAnswers(getAnswerDTOByQuestionId(question.getId()));
				questionDTOs.add(questionDTO);
			}
		}
		dto.setQuestion(questionDTOs);
		return dto;
	}
	private List<AnswerDTO> getAnswerDTOByQuestionId(Long questionId) {
		List<AnswerDTO> dtos = new ArrayList<>();
		List<AnswerEntity> entitys = answerService.findByQuestionId(questionId);
		if (entitys.isEmpty()) return dtos;
		for (AnswerEntity answer : entitys) {
			dtos.add(new AnswerDTO(answer.getId(), answer.getContent(), null));
		}
		return dtos;
	}
	@Override
	public TestQuestionDTO findById(Long testId) {
		TestEntity entity = repo.findById(testId).orElse(null);
		if (entity != null) return convertEntityToDTO(entity);
		return null;
	}
	@Override
	@Transactional
	public TestResultDTO submit(TestSubmitReq req) {
		TestResultEntity test = new TestResultEntity();
		test.setScore(caculateScore(req));
		test.setTestId(req.getTestId());
		test.setUserId(getUserId());
		test = testResultService.save(test);
		historyService.addAll(creatHistory(req, test));
		return new TestResultDTO(test.getId(), test.getTestId(), test.getScore());
	}
	
	private List<TestHistoryEntity> creatHistory(TestSubmitReq req, TestResultEntity test) {
		List<TestHistoryEntity> historys = new ArrayList<>();
		for (QuestionDTO question : req.getQuestionDTO()) {
			TestHistoryEntity history = new TestHistoryEntity();
			history.setQuestionId(question.getId());
			history.setTestId(req.getTestId());
			history.setUserId(getUserId());
			history.setTestResultId(test.getId());
			List<AnswerDTO> answerDTOs = question.getAnswers();
			StringBuilder answerIds = new StringBuilder();
			for (AnswerDTO item : answerDTOs) {
				if (!answerIds.isEmpty()) answerIds.append(",");
				answerIds.append(item.getId());
			}
			history.setAnswerIds(answerIds.toString());
			historys.add(history);
		}
		return historys;
	}
	
	private BigDecimal caculateScore(TestSubmitReq req) {
		BigDecimal score = new BigDecimal(0);
		for (QuestionDTO question : req.getQuestionDTO()) {
			List<AnswerDTO> anserDTO = question.getAnswers();
			for (AnswerDTO answerDTO : anserDTO) {
				AnswerEntity answerEntity = answerService.findById(answerDTO.getId());
				if (answerEntity.getCorrect()) score = score.add(new BigDecimal(10));
			}
		}
		return score;
	}
	
	private Long getUserId() {
		return authenticationService.getUserId();
	}
	
	@Override
	public TestEntity findByTestId(Long testId) {
		return repo.findById(testId).orElse(null);
	}
}
