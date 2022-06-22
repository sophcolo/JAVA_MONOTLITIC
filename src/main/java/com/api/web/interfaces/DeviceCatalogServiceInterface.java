package com.api.web.interfaces;

import java.util.List;

import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.dtos.DeviceCatalogDTO;
import com.api.web.model.DeviceCatalog;

public interface DeviceCatalogServiceInterface {
	public List<DeviceCatalog> all();
	public DeviceCatalog getById(String id);
	public DeviceCatalog insert(DeviceCatalogRequest dc);
	public DeviceCatalog udpate(String code, DeviceCatalogDTO dc);
	public void delete(String code);
}
