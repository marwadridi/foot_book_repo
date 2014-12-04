package tn.edu.esprit.gl.foot_bookEJB.services.interfaces;

import javax.ejb.Local;

import tn.edu.esprit.gl.foot_bookEJB.model.User;

@Local
public interface UserServicesLocal {
	User login(String login, String password);
}
