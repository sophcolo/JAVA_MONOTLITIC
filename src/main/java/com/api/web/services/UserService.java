package com.api.web.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.web.repositories.UserRepository;
import com.api.web.requests.users.UserValidator;
import com.api.web.dtos.UserRequest;
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
	public Usuario getById(String code) {
		return userRepository.findById(code).get();
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
	public Usuario udpate(String code, Usuario user) {
		Usuario user_exists = userRepository.findById(code).get();
		/*user_exists.setNam(user.getNam());
		user_exists.setCtr(user.getCtr());
		user_exists.setEnt(user.getEnt());
		user_exists.setTen(user.getTen());
		user_exists.setPem(user.getPem());
		user_exists.setIdi(user.getIdi());
		user_exists.setIdt(user.getIdt());*/
		return userRepository.save(user_exists);
	}

	@Override
	public void delete(String code) {
		userRepository.deleteById(code);
	}

}
