package tn.edu.esprit.gl.foot_bookEJB.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;

@Singleton
@Startup
public class InitDb {

	@EJB
	UserServicesLocal userServicesLocal;

	@EJB
	StadiumServicesLocal stadiumServicesLocal;

	@PostConstruct
	public void initDataBase() {

		User user = new User("user1", "user1", "user1");
		userServicesLocal.addUser(user);
		Stadium stadium = new Stadium("marsa");
		stadiumServicesLocal.addStadium(stadium);

	}

}
