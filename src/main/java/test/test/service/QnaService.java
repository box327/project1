package test.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.test.domain.QuestionData;
import test.test.domain.QuestionRepository;

@Service
public class QnaService {
	private static final Logger log = LoggerFactory.getLogger(QnaService.class);

	@Autowired
	private QuestionRepository questionRepository;
	
	public void qnaCreate(QuestionData question) {
		questionRepository.save(question);
		log.debug(question.toString());
	}
	
	public List<QuestionData> getQnaList() {
		return (List<QuestionData>) questionRepository.findAll();
	}
}
