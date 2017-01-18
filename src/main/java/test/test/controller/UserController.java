package test.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.test.domain.UserData;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	private List<UserData> userList = new ArrayList<UserData>();

	@PostMapping("/create")
	public String createUser(UserData userData)
	{
		log.debug("test");
		userList.add(userData);
		return "redirect:/user/list";
	}
	
	@GetMapping("/list")
	public String listUser(Model model)
	{
		model.addAttribute("userList", userList);
		return "user/list";
	}
}
