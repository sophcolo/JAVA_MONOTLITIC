package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.web.services.UserDeviceService;
import com.api.web.services.UserService;
import com.api.web.services.DeviceCatalogService;
import com.api.web.model.UserDevice;

@Controller
public class UserDeviceController {
		
		@Autowired
	    private UserDeviceService userDeviceService;
		@Autowired
		private UserService userService;
		@Autowired
		private DeviceCatalogService dcService;
		
		@GetMapping({"/userdevices"})
		public String index(Model model) {
			model.addAttribute("userdevices",userDeviceService.all());
			return "user-devices/index";
		}
		
		@GetMapping({"/userdevices/create"})
		public String create(Model model) {
			UserDevice userdevice = new UserDevice();
			model.addAttribute("users",userService.all());
			model.addAttribute("devices",dcService.all());
			model.addAttribute("userdevice",userdevice);
			return "user-devices/create";
		}
		
		@PostMapping("/userdevices/store")
		public String save(@ModelAttribute("userdevice") UserDevice ud) {
			userDeviceService.insert(ud);
			return "redirect:/userdevices";
		}
		
		@GetMapping({"/userdevices/edit/{code}"})
		public String edit(@PathVariable Integer code,Model model) {
			model.addAttribute("device", userDeviceService.getById(code));
			return "user-devices/edit";
		}
		
		@PostMapping({"/userdevices/update/{id}"})
		public String update(@PathVariable Integer id,@ModelAttribute("device") UserDevice dc) {
			userDeviceService.udpate(id, dc);
			return "redirect:/userdevices";
		}
		
		@GetMapping({"/userdevices/delete/{device_id}"})
		public String delete(@PathVariable Integer device_id) {
			userDeviceService.delete(device_id);
			return "redirect:/userdevices";
		}
}
