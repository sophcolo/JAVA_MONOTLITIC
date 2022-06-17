package com.api.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.web.interfaces.UserDeviceServiceInterface;
import com.api.web.model.UserDevice;
import com.api.web.repositories.UserDeviceRepository;

@Service
public class UserDeviceService implements UserDeviceServiceInterface {

	@Autowired
    private UserDeviceRepository userDeviceRepository;
	
	@Override
	public List<UserDevice> all() {
		return userDeviceRepository.findAll();
	}

	@Override
	public UserDevice getById(Integer id) {
		return userDeviceRepository.findById(id).get();
	}

	@Override
	public UserDevice insert(UserDevice ud) {
		return userDeviceRepository.save(ud);
	}

	@Override
	public UserDevice udpate(Integer id, UserDevice ud) {
		UserDevice ud_exists = userDeviceRepository.findById(id).get();
		ud_exists.setDeviceCatalog(ud.getDeviceCatalog());
		ud_exists.setUsuario(ud.getUsuario());
		ud_exists.setId_detectid(ud.getId_detectid());
		ud_exists.setEstado_detectid(ud.getEstado_detectid());
		ud_exists.setEstado_mantenimiento(ud.getEstado_mantenimiento());
		ud_exists.setNombre_dispositivo(ud.getNombre_dispositivo());
		return userDeviceRepository.save(ud_exists);
	}

	@Override
	public void delete(Integer id) {
		userDeviceRepository.deleteById(id);
	}

}
