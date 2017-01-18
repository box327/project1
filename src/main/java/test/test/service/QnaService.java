package test.test.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import test.test.domain.QuestionData;

@Service
public class QnaService {
	private List<QuestionData> questionList = new ArrayList<QuestionData>();
	private static final Logger log = LoggerFactory.getLogger(QnaService.class);

	public void qnaCreate(QuestionData question) {
		questionList.add(question);
		log.debug(question.toString());
	}
	
	public List<QuestionData> getQnaList() {
		return questionList;
	}
}
