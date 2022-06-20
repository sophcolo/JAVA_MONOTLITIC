package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.web.dtos.DeviceCatalogDTO;
import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.requests.DeviceCatalogValidator;
import com.api.web.services.DeviceCatalogService;

@RestController
@RequestMapping("/api/devices")
public class ApiDeviceCatalogController {
	@Autowired
    private DeviceCatalogService deviceCatalogService;
	
	@Autowired
	private DeviceCatalogValidator deviceValidator;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> all() {
        return ResponseEntity.ok(deviceCatalogService.all());
    }

	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getById(@PathVariable String id) {
        return ResponseEntity.ok(deviceCatalogService.getById(id));
    }

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> store(@RequestBody DeviceCatalogRequest dc) throws ApiUnprocessableEntity {	
		 this.deviceValidator.validator(dc);
         deviceCatalogService.insert(dc);
    	 return ResponseEntity.ok(Boolean.TRUE);
    }
	

    @PutMapping(value = "/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody DeviceCatalogDTO dc) {
        deviceCatalogService.udpate(id, dc);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
    	deviceCatalogService.delete(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
