package com.api.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceCatalog insert(DeviceCatalog dc) {
		return deviceCatalogRepository.save(dc);
	}

	@Override
	public DeviceCatalog udpate(String code, DeviceCatalog dc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub

	}

}
