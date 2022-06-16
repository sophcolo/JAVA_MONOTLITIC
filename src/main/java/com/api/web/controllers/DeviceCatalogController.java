package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.web.enums.OperatingSystems;
import com.api.web.enums.TelephoneOperators;
import com.api.web.model.DeviceCatalog;
import com.api.web.services.DeviceCatalogService;

@Controller
public class DeviceCatalogController {
	@Autowired
    private DeviceCatalogService dcService;
	
	@GetMapping({"/devices"})
	public String index(Model model) {
		model.addAttribute("devices",dcService.all());
		return "devices-catalog/index";
	}
	
	@GetMapping({"/devices/create"})
	public String create(Model model) {
		DeviceCatalog device = new DeviceCatalog();
		model.addAttribute("device",device);
		model.addAttribute("operatingSystems",OperatingSystems.values());
		model.addAttribute("telephoneOperators",TelephoneOperators.values());
		return "devices-catalog/create";
	}
}