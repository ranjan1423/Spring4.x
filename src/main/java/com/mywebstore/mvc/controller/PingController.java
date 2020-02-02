package com.mywebstore.mvc.controller;

import java.util.Date;
import com.mywebstore.constants.View;
import com.mywebstore.mvc.service.PingService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class PingController {
	private static final Logger LOGGER = Logger.getLogger(PingController.class);

	@Autowired
	private PingService pingService;

	@GetMapping(path = "/ping")
	public String ping(ModelMap modelMap) {
		StringBuilder msg = new StringBuilder();
		msg.append("PingController called on : ");
		msg.append(new Date());
		modelMap.addAttribute("message", msg.toString());
		LOGGER.info(msg.toString());
		return View.ping.toString();
	}

	@GetMapping(path = "/now")
	public String now(ModelMap modelMap) {
		LOGGER.info("Ping controller::now() called.");
		StringBuilder msg = new StringBuilder();
		msg.append("PingController called for now() : ");
		modelMap.addAttribute("message", pingService.now());
		return View.now.toString();
	}
}
