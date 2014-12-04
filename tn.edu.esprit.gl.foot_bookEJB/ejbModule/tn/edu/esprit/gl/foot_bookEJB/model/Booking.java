package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Booking
 *
 */
@Entity
public class Booking implements Serializable {

	private BookingId bookingId;
	private Date dateOfBooking;
	private static final long serialVersionUID = 1L;

	private User user;
	private Stadium stadium;

	public Booking() {
		super();
	}

	public Date getDateOfBooking() {
		return this.dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	@EmbeddedId
	public BookingId getBookingId() {
		return bookingId;
	}

	public void setBookingId(BookingId bookingId) {
		this.bookingId = bookingId;
	}

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "idStadium", referencedColumnName = "id", insertable = false, updatable = false)
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public Booking(User user, Stadium stadium, Date dateOfBooking) {
		super();
		this.dateOfBooking = dateOfBooking;
		this.user = user;
		this.stadium = stadium;
		this.bookingId = new BookingId(user.getId(), stadium.getId());
	}

}
