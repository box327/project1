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

import test.test.domain.QuestionData;
import test.test.domain.UserData;
import test.test.service.QnaService;
import test.test.utills.AuthUtills;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	private static final Logger log = LoggerFactory.getLogger(QnaController.class);	
	@Autowired
	QnaService qnaService;
	
	@GetMapping("/form")
	public String qnaForm(HttpSession session)
	{
		if(session.getAttribute("loginUser") == null)
		{
			return "redirect:/user/login";
		}
		return "qna/form";
	}
	
	@GetMapping("{id}/form")
	public String qnaUpdateForm(HttpSession session)
	{
		if(session.getAttribute("loginUser") == null)
		{
			return "redirect:/user/login";
		}
		return "qna/form";
	}
	
	@PutMapping("/update")
	public String qnaUpdate(HttpSession session, QuestionData updateData)
	{
		
		return "redirect:/contents/" + updateData.getId();
	}
	
	@DeleteMapping("/question/{id}")
	public String qnaDelete(HttpSession session, QuestionData deleteData)
	{
		UserData loginUser = AuthUtills.getLoginUser(session);
		
		
		
		if(loginUser.checkUser(deleteData.getWriter()))
		{
			
		}
		
		return "redirect:/";
	}
	
	@PostMapping("/question")
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
		model.addAttribute("contents", question);
		return "qna/show";
	}
}
