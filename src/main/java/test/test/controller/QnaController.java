package test.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.test.domain.QuestionData;
import test.test.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	private static final Logger log = LoggerFactory.getLogger(QnaController.class);	
	@Autowired
	QnaService qnaService;
	
	@PostMapping("/question")
	public String qnaQuestion(QuestionData questionData)
	{
		log.debug(questionData.toString());
		qnaService.qnaCreate(questionData);
		
		return "redirect:/";
	}
}
