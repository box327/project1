package test.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam()String name,Integer age,Model model)
	{
		System.out.println(name);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}
}

