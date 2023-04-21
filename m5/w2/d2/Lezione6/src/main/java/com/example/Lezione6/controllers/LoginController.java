package com.example.Lezione6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.Lezione6.models.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView showFormLogin() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	
	@PostMapping("/userlog")
	public @ResponseBody String testLogin(User user) {
		return "Nome: " + user.getName() + " email: " + user.getEmail();
	}
}
