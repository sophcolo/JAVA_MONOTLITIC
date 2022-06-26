package com.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.model.Usuario;
import com.api.web.services.UserService;

@RestController
public class ApiUserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping(value = "/api/users")
    public List<Usuario> all() {
        return userService.all();
    }
	
	@GetMapping({"/users"})
	public String index(Model model) {
		model.addAttribute("users",userService.all());
		return "index";
	}

	@GetMapping(value = "/api/users/{id}")
    public Usuario getById(@PathVariable String id) throws ApiNotFound {
        return userService.getById(id);
    }

	@PostMapping(value = "/users")
    public Usuario save(@RequestBody Usuario usr) {
        //return usr;
        return userService.insert(usr);
    }
    
    @PostMapping(value = "/api/users")
    public Usuario save(@RequestBody UserRequest usr) throws ApiUnprocessableEntity {
        return userService.save(usr);
    }

    @PutMapping(value = "/api/users/{code}")
    public Usuario update(@PathVariable String code, @RequestBody UserRequest usr) throws ApiUnprocessableEntity, ApiNotFound {
        return userService.udpate(code, usr);
    }

    @DeleteMapping(value = "/api/users/{code}")
    public String delete(@PathVariable String code) throws ApiNotFound {
        userService.delete(code);
        return "Usuario con Código: " + code + " fue borrado satisfactoriamente";
    }
}
