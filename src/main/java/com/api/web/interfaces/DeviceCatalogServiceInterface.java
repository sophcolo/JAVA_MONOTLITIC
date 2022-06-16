package com.api.web.interfaces;

import java.util.List;

import com.api.web.model.DeviceCatalog;

public interface DeviceCatalogServiceInterface {
	public List<DeviceCatalog> all();
	public DeviceCatalog getById(String id);
	public DeviceCatalog insert(DeviceCatalog dc);
	public DeviceCatalog udpate(String code, DeviceCatalog dc);
	public void delete(String code);
}
