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
		if(user != null && !user.checkPassword(password))
		{
			session.setAttribute("loginUser", user);
			return "redirect:/";
		}
		return "user/login_failed";
	}
	
	@GetMapping("/{id}/form")
	public String updadeForm(Model model, @PathVariable(value="id")Long id)
	{
		log.debug(id.toString());
		UserData user = userRepository.findOne(id);
		model.addAttribute("updateUser", user);
		log.debug(user.toString());
		return "user/form";
	}
	
	@GetMapping("/form")
	public String userForm()
	{
		return "user/form";
	}
	
	@GetMapping("/logout")
	public String userlogout(HttpSession session)
	{
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	
	@PostMapping("/update")
	public String update(UserData userData ,Long id)
	{
		log.debug(userData.toString());
		UserData user = userRepository.findOne(id);
		log.debug(user.toString());
		log.debug("user" + user.getUserId().equals(userData.getUserId()) );
		log.debug("password" + user.checkPassword(userData.getPassword()));
		if(user.getUserId().equals(userData.getUserId()) && user.checkPassword(userData.getPassword()))
		{
			log.debug("update!");
			user.setEmail(userData.getEmail());
			user.setName(userData.getName());
			userRepository.save(user);
		}
		return "redirect:/user/list";
	}
	
}
