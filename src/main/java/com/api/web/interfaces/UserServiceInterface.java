package com.api.web.interfaces;
import java.util.List;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.model.Usuario;

public interface UserServiceInterface {
	public List<Usuario> all();
	public Usuario getById(String id) throws ApiNotFound;
	public Usuario insert(Usuario usr);
	public Usuario udpate(String code, UserRequest usr) throws ApiUnprocessableEntity,ApiNotFound;
	public void delete(String code) throws ApiNotFound;
}