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

import com.api.web.model.DeviceCatalog;
import com.api.web.services.DeviceCatalogService;

@RestController
public class ApiDeviceCatalogController {
	@Autowired
    private DeviceCatalogService deviceCatalogService;
	
	@GetMapping(value = "/api/devices")
    public List<DeviceCatalog> all() {
        return deviceCatalogService.all();
    }

	@GetMapping(value = "/api/devices/{id}")
    public DeviceCatalog getById(@PathVariable String id) {
        return deviceCatalogService.getById(id);
    }

    @PostMapping(value = "/api/devices")
    public DeviceCatalog save(@RequestBody DeviceCatalog dc) {
    	 return deviceCatalogService.insert(dc);
    }

    @PutMapping(value = "/api/devices{id}")
    public DeviceCatalog update(@PathVariable String code, @RequestBody DeviceCatalog dc) {
        return deviceCatalogService.udpate(code, dc);
    }

    @DeleteMapping(value = "/api/devices/{id}")
    public String delete(@PathVariable String code) {
    	deviceCatalogService.delete(code);
        return "User con Código: " + code + " fue borrado satisfactoriamente";
    }
}
