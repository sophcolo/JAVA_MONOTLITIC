package com.api.web.controllers;
import com.api.web.enums.Countries;
import com.api.web.enums.SecurityLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.api.web.model.Usuario;
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
		Usuario user = new Usuario();
		model.addAttribute("user",user);
		model.addAttribute("countries",Countries.values());
		model.addAttribute("securitylevels",SecurityLevels.values());
		return "users/create";
	}
	
	@PostMapping("/users/store")
	public String save(@ModelAttribute("user") Usuario user) {
		userService.insert(user);
		return "redirect:/";
	}
	
	@GetMapping({"/users/edit/{code}"})
	public String edit(@PathVariable String code,Model model) {
		model.addAttribute("user", userService.getById(code));
		model.addAttribute("countries",Countries.values());
		model.addAttribute("securitylevels",SecurityLevels.values());
		return "users/edit";
	}
	
	@PostMapping({"/users/update/{code}"})
	public String update(@PathVariable String code,@ModelAttribute("user") Usuario user) {
		userService.udpate(code, user);
		return "redirect:/";
	}
	
	@GetMapping({"/users/delete/{code}"})
	public String delete(@PathVariable String code) {
		userService.delete(code);
		return "redirect:/";
	}
}