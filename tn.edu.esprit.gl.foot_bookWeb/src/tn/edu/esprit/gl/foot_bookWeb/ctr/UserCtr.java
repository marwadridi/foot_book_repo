package tn.edu.esprit.gl.foot_bookWeb.ctr;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.edu.esprit.gl.foot_bookEJB.model.Admin;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;

@ManagedBean(name = "userManager")
@SessionScoped
public class UserCtr {
	// model
	private User user = new User();

	private String login;
	private String pwd;
	private boolean connected;

	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	public String doLogin() {
		String navigateTo = "";
		user = userServicesLocal.login(login, pwd);

		if (user != null) {
			connected = true;
			if (user.getClass()==Admin.class) {
				navigateTo = "/pages/admin/manageUsers?faces-redirect=true";
				

			} else {

				navigateTo = "/pages/user/bookingInterface?faces-redirect=true";
				

			}

		} else {
			navigateTo = "/error?faces-redirect=true";
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
