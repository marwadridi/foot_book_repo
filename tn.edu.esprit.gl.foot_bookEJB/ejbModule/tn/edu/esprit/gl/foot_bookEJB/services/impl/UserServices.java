package tn.edu.esprit.gl.foot_bookEJB.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */

	public UserServices() {
	}

	@Override
	public User login(String login, String password) {
		User userFound = null;
		String jpql = "SELECT u FROM User u WHERE u.login=:login and u.password=:password";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			userFound = (User) query.getSingleResult();
		} catch (Exception e) {
			System.err.println("user not found ...");
		}
		return userFound;
	}

}
