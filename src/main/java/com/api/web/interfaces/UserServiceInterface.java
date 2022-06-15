package com.api.web.interfaces;
import java.util.List;
import com.api.web.model.User;

public interface UserServiceInterface {
	public List<User> all();
	public User getById(String id);
	public User insert(User usr);
	public User udpate(String code, User usr);
	public void delete(String code);
}