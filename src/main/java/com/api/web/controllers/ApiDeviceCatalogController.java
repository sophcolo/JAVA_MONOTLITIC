package com.api.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.model.DeviceCatalog;
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
    public ResponseEntity<DeviceCatalog> getById(@PathVariable String id) throws ApiNotFound {
		this.deviceValidator.validatorIndentity(id);
		DeviceCatalog deviceCatalog = deviceCatalogService.getById(id).get();
		return new ResponseEntity<>(deviceCatalog, HttpStatus.OK);
    }
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public DeviceCatalog store(@RequestBody DeviceCatalogRequest dc) throws ApiUnprocessableEntity {	
		 this.deviceValidator.validatorRequest(dc);
    	 return deviceCatalogService.insert(dc);
    }
	
	@PutMapping("{id}")
    public ResponseEntity<DeviceCatalog> updateEmployee(@PathVariable String id,@RequestBody DeviceCatalogRequest dc) throws ApiNotFound, ApiUnprocessableEntity{
		this.deviceValidator.validatorIndentity(id);
		this.deviceValidator.validatorRequest(dc);
		DeviceCatalog updatedDC = deviceCatalogService.udpate(id, dc);
		return new ResponseEntity<>(updatedDC, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String id) throws ApiNotFound{
    	this.deviceValidator.validatorIndentity(id);
    	deviceCatalogService.delete(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
