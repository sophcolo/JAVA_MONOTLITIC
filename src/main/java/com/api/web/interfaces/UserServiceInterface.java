package com.api.web.interfaces;

import com.api.web.dtos.UserRequest;
import com.api.web.model.Usuario;

public interface UserServiceInterface extends BaseServiceInterface<Usuario,UserRequest,String>{

	Usuario insert(Usuario usr);
}