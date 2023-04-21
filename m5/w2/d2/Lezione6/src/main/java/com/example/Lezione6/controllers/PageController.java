package com.example.Lezione6.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/api")
public class PageController {

	@GetMapping("/homepage")
	public @ResponseBody String getHomePage() {
		return "HomePage Spring Web MVC";
	}
	
	@GetMapping("/test")
	public @ResponseBody String getTestParams1(@RequestParam String name, @RequestParam String lastname) {
		return "Test parameter: " + name + " " + lastname;
	}
	
	@GetMapping("/test2/{name}/{lastname}")
	public @ResponseBody String getTestParams2(@PathVariable String name, @PathVariable String lastname) {
		return "Test2 parameter: " + name + " " + lastname;
	}
	
	@GetMapping("/test3/{name}/{lastname}")
	public String getTestThymeleaf(
			Map<String, Object> model,
			@PathVariable String name,
			@PathVariable String lastname) {
		model.put("testName", name);
		model.put("testLastname", lastname);
		return "test";
	}
	
	@GetMapping("/test4/{name}/{lastname}")
	public ModelAndView getTestThymeleaf(
			@PathVariable String name,
			@PathVariable String lastname) {
		ModelAndView model = new ModelAndView("test");
		model.addObject("testName", name);
		model.addObject("testLastname", lastname);
		return model;
	}
	
	@GetMapping("/contact")
	public @ResponseBody String getContactPage() {
		return "Contact Spring Web MVC";
	}
}
