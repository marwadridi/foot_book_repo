package tn.edu.esprit.gl.foot_bookWeb.ctr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;


@ManagedBean(name="gestionUsersCtr")
@ViewScoped
public class ManageUsersCtr {
	
	
	@EJB
	UserServicesLocal userServicesLocal;
	
	private List<User> users = new ArrayList<User>();
	private User user = new User();
	private boolean displayForm =false;
	
	public ManageUsersCtr() {
		
	}
	
	
	@PostConstruct
	public void init()
	{
		users=userServicesLocal.getAllUsers();
		
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public String doSave()
	{
		
		userServicesLocal.addOrUpdateUser(user);
		init();
		return null;

	}
	public String doDelete()
	{
		userServicesLocal.delete(user);
		init();
		return null;
	}
	public String doCancel()
	{
		user=new User();
		displayForm=false;
		return null;
	}
	
	public String doNew()
	{
		displayForm=true;
		return null;
	}


	public boolean isDisplayForm() {
		return displayForm;
	}


	public void setDisplayForm(boolean displayForm) {
		this.displayForm = displayForm;
	}
	
	public void onRowSelect(SelectEvent event)
	{
		displayForm=true;
	}

}
