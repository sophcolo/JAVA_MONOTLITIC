package com.api.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.dtos.DeviceCatalogDTO;
import com.api.web.helpers.HelperMapper;
import com.api.web.interfaces.DeviceCatalogServiceInterface;
import com.api.web.model.DeviceCatalog;
import com.api.web.repositories.DeviceCatalogRepository;


@Service
public class DeviceCatalogService implements DeviceCatalogServiceInterface {
	
	@Autowired
    private DeviceCatalogRepository deviceCatalogRepository;

	@Override
	public List<DeviceCatalog> all() {
		return deviceCatalogRepository.findAll();
	}

	@Override
	public DeviceCatalog getById(String id) {
		return deviceCatalogRepository.findById(id).get();
	}

	@Override
	public void insert(DeviceCatalogRequest dc) {
		DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(dc, DeviceCatalog.class);
		deviceCatalogRepository.save(devicecatalog);
	}
	
	@Override
	public DeviceCatalog udpate(String code, DeviceCatalogDTO dc) {
		DeviceCatalog devicecatalog = deviceCatalogRepository.findById(code).get();
		HelperMapper.modelMapper().map(dc, devicecatalog);
		return deviceCatalogRepository.save(devicecatalog);
	}

	@Override
	public void delete(String device_id) {
		deviceCatalogRepository.deleteById(device_id);
	}
}
