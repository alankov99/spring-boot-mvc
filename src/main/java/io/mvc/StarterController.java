package io.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarterController {

	@RequestMapping("home")
	public String home() {
		System.out.println("home.jsp");
		return "home.jsp";
	}

	@RequestMapping("/")
	public String index() {
		System.out.println("index.jsp");
		return "index.jsp";
	}

	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
}
