package test.test.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.test.domain.AnswerData;
import test.test.domain.QuestionData;
import test.test.domain.UserData;
import test.test.service.AnswerService;
import test.test.service.QnaService;
import test.test.utills.AuthUtills;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	private static final Logger log = LoggerFactory.getLogger(QnaController.class);	
	@Autowired
	QnaService qnaService;
	
	@Autowired
	AnswerService answerService;
	
	@GetMapping("/new")
	public String qnaForm(HttpSession session)
	{
		if(session.getAttribute("loginUser") == null)
		{
			return "redirect:/user/login";
		}
		return "qna/form";
	}
	
	@GetMapping("{id}/edit")
	public String qnaUpdateForm(HttpSession session)
	{
		if(session.getAttribute("loginUser") == null)
		{
			return "redirect:/user/login";
		}
		return "qna/form";
	}
	
	@PutMapping("/{{id}}")
	public String qnaUpdate(HttpSession session, QuestionData updateData)
	{
		
		return "redirect:/contents/" + updateData.getId();
	}
	
	@DeleteMapping("/{id}")
	public String qnaDelete(HttpSession session, QuestionData deleteData)
	{
		UserData loginUser = AuthUtills.getLoginUser(session);
		
		
		
		if(loginUser.checkUser(deleteData.getWriter()))
		{
			
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/")
	public String qnaQuestion(QuestionData questionData,HttpSession session)
	{
		UserData loginUser = AuthUtills.getLoginUser(session);
		
		
		questionData.setWriter(loginUser);
		questionData.setWriteDate(new Date());
		log.debug(questionData.toString());
		qnaService.qnaCreate(questionData);
		return "redirect:/";
	}
	
	@GetMapping("/contents/{id}")
	public String qnaQuestion(Model model,QuestionData questionData, @PathVariable(name = "id")Long id)
	{
		QuestionData question = qnaService.getQnaContents(id);
		log.debug(question.toString());
		model.addAttribute("contents", question);
		return "qna/show";
	}
	
	@PostMapping("/{id}/answer")
	public String answerListFromQuestion(AnswerData answer,@PathVariable(name = "id")Long questionId ,HttpSession session)
	{
		
		
		
		UserData loginUser = AuthUtills.getLoginUser(session);
		QuestionData question = qnaService.getQnaContents(questionId);
		
		answer.setQuestion(question);
		answer.setWriter(loginUser);
		
		log.debug(answer.toString());
		
		answerService.answerCreate(answer);
		return "redirect:/qna/contents/" + answer.getQuestion().getId();
	}
	
}
