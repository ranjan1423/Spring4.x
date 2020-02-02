package com.mywebstore.mvc.controller;

import com.mywebstore.constants.View;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class HomeController {
	private static final Logger LOGGER = Logger.getLogger(HomeController.class);

	@GetMapping(path = "/home")
	public String home() {
		System.out.println("home...");
		LOGGER.info("home controller called.");
		return View.home.toString();
	}
}
