package com.api.web.interfaces;
import java.util.List;
import com.api.web.model.Usuario;

public interface UserServiceInterface {
	public List<Usuario> all();
	public Usuario getById(String id);
	public Usuario insert(Usuario usr);
	public Usuario udpate(String code, Usuario usr);
	public void delete(String code);
}