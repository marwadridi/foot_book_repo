package tn.edu.esprit.gl.foot_bookEJB.services.impl;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<User>();
		String statement = "SELECT u from User u";
		Query query = entityManager.createQuery(statement);
		users = query.getResultList();
		return users;
		
	}

	@Override
	public void addOrUpdateUser(User user) {
		entityManager.merge(user);

	}

	@Override
	public void delete(User user) {
		entityManager.remove(entityManager.merge(user));

	}

}
