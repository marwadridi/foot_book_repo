package tn.edu.esprit.gl.foot_bookWeb.ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserCtr {
	// model
	private User user = new User();

	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	public String doLogin() {
		String navigateTo = "";
		User userFound = userServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userFound != null) {
			user = userFound;
			navigateTo = "/user/userHome?send-redirect=true";

		} else {
			navigateTo = "/error?send-redirect=true";
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
