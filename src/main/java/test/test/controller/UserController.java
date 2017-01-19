package test.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.test.domain.UserData;
import test.test.domain.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/create")
	public String createUser(UserData userData)
	{
		log.debug("test");
		userRepository.save(userData);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String listUser(Model model)
	{
		model.addAttribute("userList", userRepository.findAll());
		return "user/list";
	}
	
	@GetMapping("/login")
	public String getLogin()
	{
		return "user/login";
	}
	
	@PostMapping("/login")
	public String Postlogin(String userId, String password, HttpSession session)
	{
		log.debug("userId : " + userId + " password : " + password);
		UserData user = userRepository.findByUserId(userId);
		if(user != null && user.checkPassword(password))
		{
			return "redirect:/";
		}
		return "user/login_failed";
	}
	
	@GetMapping("/{id}/form")
	public String updadeForm(Model model, @PathVariable(value="id")Long id)
	{
		log.debug(id.toString());
		UserData user = userRepository.findOne(id);
		model.addAttribute("user", user);
		log.debug(user.toString());
		return "user/form";
	}
	
	@PostMapping("/update")
	public String update(Model model,UserData userData ,Long id)
	{
		UserData user = userRepository.findOne(id);
		user.setEmail(userData.getEmail());
		user.setName(userData.getName());
		user.setUserId(userData.getUserId());
		user.setPassword(userData.getPassword());
		userRepository.save(user);
		return "redirect:/user/list";
	}
	
}
