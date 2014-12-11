package tn.edu.esprit.gl.foot_bookEJB.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesRemote;

/**
 * Session Bean implementation class StadiumServices
 */
@Stateless
public class StadiumServices implements StadiumServicesRemote,
		StadiumServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StadiumServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Stadium> findAllStadiums() {

		String jpql = "select s from Stadium s";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public void addStadium(Stadium stadium) {
		entityManager.persist(stadium);

	}

}
