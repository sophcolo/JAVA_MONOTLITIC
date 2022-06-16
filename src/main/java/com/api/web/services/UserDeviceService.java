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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDevice insert(UserDevice ud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDevice udpate(Integer code, UserDevice ud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer code) {
		// TODO Auto-generated method stub

	}

}
