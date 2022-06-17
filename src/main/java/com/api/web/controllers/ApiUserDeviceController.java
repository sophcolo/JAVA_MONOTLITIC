package com.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.web.model.UserDevice;
import com.api.web.services.UserDeviceService;

@RestController
public class ApiUserDeviceController {
	@Autowired
    private UserDeviceService userDeviceService;
	
	@GetMapping(value = "/api/userdevices")
    public List<UserDevice> all() {
        return userDeviceService.all();
    }

	@GetMapping(value = "/api/userdevices/{id}")
    public UserDevice getById(@PathVariable Integer id) {
        return userDeviceService.getById(id);
    }

    @PostMapping(value = "/api/userdevices")
    public UserDevice save(@RequestBody UserDevice ud) {
        return userDeviceService.insert(ud);
    }

    @PutMapping(value = "/api/userdevices/{id}")
    public UserDevice update(@PathVariable Integer id, @RequestBody UserDevice usr) {
        return userDeviceService.udpate(id, usr);
    }

    @DeleteMapping(value = "/api/userdevices/{id}")
    public String delete(@PathVariable Integer id) {
    	userDeviceService.delete(id);
        return "User con Código: " + id + " fue borrado satisfactoriamente";
    }
}
