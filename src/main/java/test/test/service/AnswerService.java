package test.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.test.domain.AnswerData;
import test.test.domain.AnswerRepository;

@Service
public class AnswerService {

	private static final Logger log = LoggerFactory.getLogger(AnswerService.class);

	@Autowired
	AnswerRepository answerRepository;
	
	public void answerCreate(AnswerData answer) {
		answerRepository.save(answer);
		
	}

}
