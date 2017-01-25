package test.test.controller;

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

import test.test.domain.UserData;
import test.test.domain.UserRepository;
import test.test.utills.AuthUtills;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String listUser(Model model)
	{
		model.addAttribute("userList", userRepository.findAll());
		return "user/list";
	}
	
	@GetMapping("/new")
	public String userForm()
	{
		return "user/form";
	}
	
	@PostMapping("/")
	public String createUser(UserData userData)
	{
		log.debug("test");
		userRepository.save(userData);
		return "redirect:/user/";
	}
	
	@GetMapping("/{id}/edit")
	public String updadeForm(Model model, @PathVariable(value="id")Long id,HttpSession session)
	{
		illegalAccessCheck(id, session);
		
		log.debug(id.toString());
		UserData user = userRepository.findOne(id);
		model.addAttribute("updateUser", user);
		log.debug(user.toString());
		return "user/form";
	}
	
	@GetMapping("/{id}")
	public String getProfile(@PathVariable(value="id")Long id,HttpSession session,Model model)
	{
		UserData user = userRepository.findOne(id);
		model.addAttribute("user", user);
		
		return "user/profile";
	}
	
	@PutMapping("/{id}")
	public String updateUser(UserData userData ,@PathVariable(value="id")Long id,HttpSession session)
	{
		
		illegalAccessCheck(id, session);
		
		log.debug(userData.toString());
		UserData user = userRepository.findOne(id);
		log.debug(user.toString());
		log.debug("user" + user.getUserId().equals(userData.getUserId()) );
		log.debug("password" + user.checkPassword(userData.getPassword()));
		
		boolean check = user.userUpdate(userData);
		
		if(check == true)
			userRepository.save(user);
		
		return "redirect:/user/";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable(value="id")Long id)
	{
		userRepository.delete(id);
		return "redirect:/user/list";
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
			AuthUtills.login(session, user);
			return "redirect:/";
		}
		return "user/login_failed";
	}
	
	@GetMapping("/logout")
	public String userlogout(HttpSession session)
	{
		AuthUtills.logout(session);
		return "redirect:/";
	}
	
	
	
	

	private void illegalAccessCheck(Long id, HttpSession session) throws IllegalAccessError {
		UserData loginUser = AuthUtills.getLoginUser(session);

		if(loginUser == null || loginUser.getId() != id)
			throw new IllegalAccessError();
	}
	
}
