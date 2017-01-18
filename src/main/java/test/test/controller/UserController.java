package test.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import test.test.domain.UserData;

@Controller
@RequestMapping("/user")
public class UserController {
	private List<UserData> userList = new ArrayList<UserData>();
	
	@PostMapping("/create")
	public String createUser(UserData userData)
	{
		userList.add(userData);
		System.out.println(userList);
		return "";
	}
}
