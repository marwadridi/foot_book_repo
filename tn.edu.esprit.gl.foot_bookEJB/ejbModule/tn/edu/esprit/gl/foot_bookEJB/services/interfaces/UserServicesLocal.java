package tn.edu.esprit.gl.foot_bookEJB.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.gl.foot_bookEJB.model.User;

@Local
public interface UserServicesLocal {
	User login(String login, String password);

	void addUser(User user);

	List<User> getAllUsers();

	void addOrUpdateUser(User user);

	void delete(User user);

	
}
