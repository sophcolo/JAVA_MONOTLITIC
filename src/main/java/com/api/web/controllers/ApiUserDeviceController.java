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

import com.api.web.dtos.UserDeviceRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
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
    public UserDevice getById(@PathVariable Integer id) throws ApiNotFound {
        return userDeviceService.getById(id);
    }

    @PostMapping(value = "/api/userdevices")
    public UserDevice save(@RequestBody UserDeviceRequest ud) throws ApiUnprocessableEntity, ApiNotFound {
        return userDeviceService.save(ud);
    	//return ud;
    }
    
    @PostMapping(value = "/api/userdevicesone")
    public UserDevice insert(@RequestBody UserDevice ud) {
        return userDeviceService.insert(ud);
    }

    @PutMapping(value = "/api/userdevices/{id}")
    public UserDevice update(@PathVariable Integer id, @RequestBody UserDeviceRequest usr) throws ApiUnprocessableEntity, ApiNotFound {
        return userDeviceService.udpate(id, usr);
    }

    @DeleteMapping(value = "/api/userdevices/{id}")
    public String delete(@PathVariable Integer id) throws ApiNotFound {
    	userDeviceService.delete(id);
        return "User con Código: " + id + " fue borrado satisfactoriamente";
    }
}
