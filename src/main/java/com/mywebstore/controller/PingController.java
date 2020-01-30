package com.mywebstore.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/")
public class PingController {
	
	
	@GetMapping(path="/ping")
	public String home(ModelMap modelMap) {
		StringBuilder msg = new StringBuilder();
		msg.append("Ping controller called on : ");
		msg.append(new Date());
		modelMap.addAttribute("message", msg.toString());
		System.out.println(msg.toString());
		return "ping";
	}
}
