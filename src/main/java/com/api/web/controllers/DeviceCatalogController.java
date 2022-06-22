package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.web.enums.OperatingSystems;
import com.api.web.enums.TelephoneOperators;
import com.api.web.model.DeviceCatalog;
import com.api.web.dtos.DeviceCatalogDTO;
import com.api.web.dtos.DeviceCatalogRequest;
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
		device.setUsuario_ingresa("100001");
		model.addAttribute("device",device);
		model.addAttribute("operatingSystems",OperatingSystems.values());
		model.addAttribute("telephoneOperators",TelephoneOperators.values());
		return "devices-catalog/create";
	}
	
	@PostMapping("/devices/store")
	public String save(@ModelAttribute("device") DeviceCatalogRequest dc) {
		dcService.insert(dc);
		return "redirect:/devices";
	}
	
	@GetMapping({"/devices/edit/{code}"})
	public String edit(@PathVariable String code,Model model) {
		DeviceCatalog device = dcService.getById(code).get();
		model.addAttribute("device", device);
		model.addAttribute("operatingSystems",OperatingSystems.values());
		model.addAttribute("telephoneOperators",TelephoneOperators.values());
		return "devices-catalog/edit";
	}
	
	@PostMapping({"/devices/update/{device_id}"})
	public String update(@PathVariable String device_id,@ModelAttribute("device") DeviceCatalogDTO dc) {
		dcService.udpate(device_id, dc);
		return "redirect:/devices";
	}
	
	@GetMapping({"/devices/delete/{device_id}"})
	public String delete(@PathVariable String device_id) {
		dcService.delete(device_id);
		return "redirect:/devices";
	}
}