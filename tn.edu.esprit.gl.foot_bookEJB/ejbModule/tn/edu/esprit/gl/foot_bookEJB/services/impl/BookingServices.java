package tn.edu.esprit.gl.foot_bookEJB.services.impl;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl.foot_bookEJB.model.Booking;
import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServicesRemote;

/**
 * Session Bean implementation class BookingServices
 */
@Stateless
public class BookingServices implements BookingServicesRemote,
		BookingServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public BookingServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean bookStadium(User user, Stadium stadium, Date dateOfBooking) {
		boolean b = false;
		try {
			Booking booking = new Booking(user, stadium, dateOfBooking);
			entityManager.persist(booking);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

}
