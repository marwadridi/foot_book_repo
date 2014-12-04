package tn.edu.esprit.gl.foot_bookEJB.services.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;

@Local
public interface StadiumServicesLocal {
	List<Stadium> findAllStadiums();

	void addStadium(Stadium stadium);

}
