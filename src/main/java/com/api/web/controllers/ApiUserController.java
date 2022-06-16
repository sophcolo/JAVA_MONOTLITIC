package com.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.web.model.Usuario;
import com.api.web.services.UserService;

@RestController
public class ApiUserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping(value = "/users")
    public List<Usuario> all() {
        return userService.all();
    }

	@GetMapping(value = "/users/{id}")
    public Usuario getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping(value = "/users")
    public Usuario save(@RequestBody Usuario usr) {
        //return usr;
        return userService.insert(usr);
    }

    @PutMapping(value = "/users/{id}")
    public Usuario update(@PathVariable String code, @RequestBody Usuario usr) {
        return userService.udpate(code, usr);
    }

    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable String code) {
        userService.delete(code);
        return "User con Código: " + code + " fue borrado satisfactoriamente";
    }
}
