package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Stadium
 *
 */
@Entity
public class Stadium implements Serializable {

	private int id;
	private String libele;
	private static final long serialVersionUID = 1L;

	private List<Booking> bookings;

	public Stadium() {
		super();
	}

	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibele() {
		return this.libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	@OneToMany(mappedBy = "stadium")
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
