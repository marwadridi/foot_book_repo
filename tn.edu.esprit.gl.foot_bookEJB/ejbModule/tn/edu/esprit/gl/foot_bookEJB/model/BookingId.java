package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookingId implements Serializable {
	private int idUser;
	private int idStadium;

	public BookingId() {
		// TODO Auto-generated constructor stub
	}

	public BookingId(int idUser, int idStadium) {
		super();
		this.idUser = idUser;
		this.idStadium = idStadium;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStadium;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingId other = (BookingId) obj;
		if (idStadium != other.idStadium)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdStadium() {
		return idStadium;
	}

	public void setIdStadium(int idStadium) {
		this.idStadium = idStadium;
	}

}
