package com.sts.web.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping(path = "/home")
	public String home() {
		System.out.println("hi console");
		return "home.jsp";
	}
}
