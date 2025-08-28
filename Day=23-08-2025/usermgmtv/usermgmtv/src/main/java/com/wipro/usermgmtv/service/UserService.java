package com.wipro.usermgmtv.service;


import java.util.List;

import com.wipro.usermgmtv.dto.Token;
import com.wipro.usermgmtv.entity.User;

public interface UserService {

	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int id);
	Token login(User user);
	
}
