package com.api.web.interfaces;

import java.util.List;

import com.api.web.model.UserDevice;

public interface UserDeviceServiceInterface {
	public List<UserDevice> all();
	public UserDevice getById(Integer id);
	public UserDevice insert(UserDevice ud);
	public UserDevice udpate(Integer code, UserDevice ud);
	public void delete(Integer code);
}
