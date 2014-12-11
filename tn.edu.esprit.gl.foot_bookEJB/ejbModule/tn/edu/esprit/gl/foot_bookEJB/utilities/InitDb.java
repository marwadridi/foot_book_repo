package tn.edu.esprit.gl.foot_bookEJB.utilities;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.edu.esprit.gl.foot_bookEJB.model.Admin;
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

	private List<User> users2;

	@PostConstruct
	public void initDataBase() {

		User user = new User("a", "a", "test2", "test2", "test2@esprit.tn",
				"tunis");
		userServicesLocal.addUser(user);
		Stadium stadium = new Stadium("hamamLanf");
		stadiumServicesLocal.addStadium(stadium);

		Admin admin = new Admin();
		admin.setLogin("admin");
		admin.setPassword("admin");
		admin.setFirstName("firstName");
		userServicesLocal.addUser(admin);
		userServicesLocal.addUser(user);

	}

}
