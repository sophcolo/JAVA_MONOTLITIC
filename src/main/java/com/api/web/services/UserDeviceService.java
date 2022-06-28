package com.api.web.services;

import java.util.List;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.web.dtos.UserDeviceRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.helpers.HelperMapper;
import com.api.web.interfaces.UserDeviceServiceInterface;
import com.api.web.model.UserDevice;
import com.api.web.model.Usuario;
import com.api.web.repositories.DeviceCatalogRepository;
import com.api.web.repositories.UserDeviceRepository;
import com.api.web.requests.users.UserDeviceValidator;

import lombok.var;

@Service
public class UserDeviceService implements UserDeviceServiceInterface {

	@Autowired
    private UserDeviceRepository userDeviceRepository;
	
	@Autowired
	private UserDeviceValidator userDeviceValidator;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private DeviceCatalogRepository deviceCatalogRepository;
	
	//private ModelMapper modelMapper;
	
	@Override
	public List<UserDevice> all() {
		return userDeviceRepository.findAll();
	}

	@Override
	public UserDevice getById(Integer id) throws ApiNotFound {
		var ud = userDeviceRepository.findById(id);
		if(!ud.isPresent() ) {
			throw new ApiNotFound("Not Exists This User Device Register");
		}
		return ud.get();
	}
	
	public UserDevice insert(UserDevice ud) {
		return userDeviceRepository.save(ud);
		//return ud;
	}

	@Override
	public UserDevice save(UserDeviceRequest ud) throws ApiUnprocessableEntity, ApiNotFound {
		this.foreingValidations(ud);
		this.userDeviceValidator.validatorRequest(ud);
		UserDevice userDevice = HelperMapper.modelMapper().map(ud, UserDevice.class);
		/*UserDevice userDevice = HelperMapper.modelMapper()
				.typeMap(UserDeviceRequest.class, UserDevice.class)
				.addMapping(UserDeviceRequest::getUsuario, UserDevice::setUsuario)//In order To Update According Value
				.addMapping(UserDeviceRequest::getDeviceCatalog, UserDevice::setDeviceCatalog) //In order To Update According Value
				.map(ud_with_validations);*/
		return userDeviceRepository.save(userDevice);
		//return userDevice;
	}

	@Override
	public UserDevice udpate(Integer id, UserDeviceRequest ud) throws ApiUnprocessableEntity, ApiNotFound {
		this.foreingValidations(ud);
		this.userDeviceValidator.validatorRequest(ud);
		UserDevice user_device_exists = this.getById(id);
		HelperMapper.modelMapper().map(ud, user_device_exists);
 		return userDeviceRepository.save(user_device_exists);
	}

	@Override
	public void delete(Integer id) throws ApiNotFound {
		UserDevice user_device_exists = this.getById(id);
		userDeviceRepository.delete(user_device_exists);
	}
	
	private void foreingValidations(UserDeviceRequest ud) throws ApiNotFound {
		//Validation User Exists
		Usuario user= userService.getById(ud.getUsuario_id());
		//Validation Device Exists
		var dc = deviceCatalogRepository.findById(ud.getDevice_id());
		if(!dc.isPresent() ) {
			throw new ApiNotFound("Not Exists This Device");
		}
		ud.setUsuario(user);
		ud.setDeviceCatalog(dc.get());
	}
}