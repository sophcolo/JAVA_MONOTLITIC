package com.api.web.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.web.repositories.UserRepository;
import com.api.web.requests.users.UserValidator;

import lombok.var;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.helpers.HelperMapper;
import com.api.web.interfaces.UserServiceInterface;
import com.api.web.model.Usuario;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	@Override
	public List<Usuario> all() {
		return userRepository.findAll();
	}

	@Override
	public Usuario getById(String code) throws ApiNotFound {
		var dc = userRepository.findById(code);
		if(!dc.isPresent() ) {
			throw new ApiNotFound("Not Exists This User");
		}
		return dc.get();
	}

	@Override
	public Usuario insert(Usuario usr) {
		return userRepository.save(usr);
	}
	
	public Usuario save(UserRequest usr) throws ApiUnprocessableEntity {
		this.userValidator.validatorRequest(usr);
		Usuario user = HelperMapper.modelMapper().map(usr, Usuario.class);
		return userRepository.save(user);
	}

	@Override
	public Usuario udpate(String code, UserRequest user) throws ApiUnprocessableEntity, ApiNotFound {
		this.userValidator.validatorRequest(user);
		Usuario user_exists = this.getById(code);
		HelperMapper.modelMapper().map(user, user_exists);
		return userRepository.save(user_exists);
	}

	@Override
	public void delete(String code) throws ApiNotFound {
		var dc = userRepository.findById(code);
		if(!dc.isPresent() ) {
			throw new ApiNotFound("Not Exists This User");
		}
		userRepository.deleteById(code);
	}

}
