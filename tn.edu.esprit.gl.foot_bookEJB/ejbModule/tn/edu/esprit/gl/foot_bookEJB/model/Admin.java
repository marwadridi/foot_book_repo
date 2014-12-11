package tn.edu.esprit.gl.foot_bookEJB.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity

public class Admin extends User implements Serializable {

	
	private static final long serialVersionUID = -7821315286294540521L;

	private String role;

	public Admin() {
		super();
	}

	public String getTache() {
		return role;
	}

	public void setTache(String tache) {
		this.role = tache;
	}

}
