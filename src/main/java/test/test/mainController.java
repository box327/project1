package test.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	
	@GetMapping("/hello")
	public String hello(String name,Integer age,Model model)
	{
		System.out.println(name);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}
}
