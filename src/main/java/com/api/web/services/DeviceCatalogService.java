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
		return deviceCatalogRepository.findById(id).get();
	}

	@Override
	public DeviceCatalog insert(DeviceCatalog dc) {
		return deviceCatalogRepository.save(dc);
	}

	@Override
	public DeviceCatalog udpate(String code, DeviceCatalog dc) {
		DeviceCatalog dc_exists = deviceCatalogRepository.findById(code).get();
		dc_exists.setAgente(dc.getAgente());
		dc_exists.setIdentificador(dc.getIdentificador());
		dc_exists.setNumero_telefono(dc.getNumero_telefono());
		dc_exists.setOperador_telefonico(dc.getOperador_telefonico());
		dc_exists.setSistema_operativo(dc.getSistema_operativo());
		dc_exists.setVersion_sistema(dc.getVersion_sistema());
		dc_exists.setModelo_dispositivo(dc.getModelo_dispositivo());
		dc_exists.setEstado_dispositivo(dc.getEstado_dispositivo());
		dc_exists.setNumero_imei(dc.getNumero_imei());
		dc_exists.setDireccion_wifi(dc.getDireccion_wifi());
		dc_exists.setDireccion_bluetooth(dc.getDireccion_bluetooth());
		dc_exists.setNumero_serie(dc.getNumero_serie());
		return deviceCatalogRepository.save(dc_exists);
	}

	@Override
	public void delete(String device_id) {
		deviceCatalogRepository.deleteById(device_id);
	}

}
