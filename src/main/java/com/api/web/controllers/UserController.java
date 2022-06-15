package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.api.web.model.User;
import com.api.web.services.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;
	
	@GetMapping({"/"})
	public String index(Model model) {
		model.addAttribute("users",userService.all());
		return "index";
	}
	
	@GetMapping({"/users/create"})
	public String create(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "users/create";
	}
	
	@PostMapping("/users/store")
	public String save(@ModelAttribute("user") User user) {
		userService.insert(user);
		return "redirect:/";
	}
	
	@GetMapping({"/users/edit/{code}"})
	public String edit(@PathVariable String code,Model model) {
		model.addAttribute("user", userService.getById(code));
		return "users/edit";
	}
	
	@PostMapping({"/users/update/{code}"})
	public String update(@PathVariable String code,@ModelAttribute("user") User user) {
		userService.udpate(code, user);
		return "redirect:/";
	}
	
	@GetMapping({"/users/delete/{code}"})
	public String delete(@PathVariable String code) {
		userService.delete(code);
		return "redirect:/";
	}
}