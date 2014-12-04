package tn.edu.esprit.gl.foot_bookWeb.ctr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import tn.edu.esprit.gl.foot_bookEJB.model.Stadium;
import tn.edu.esprit.gl.foot_bookEJB.model.User;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.BookingServicesLocal;
import tn.edu.esprit.gl.foot_bookEJB.services.interfaces.StadiumServicesLocal;

@ManagedBean(name = "stadiumManager")
@SessionScoped
public class StadiumCtr {
	private List<Stadium> stadiums = new ArrayList<Stadium>();
	private Stadium stadiumSelected = new Stadium();
	private DataModel<Stadium> datamodel = new ListDataModel<Stadium>();
	private User userConnected = new User();

	@ManagedProperty(value = "#{userManager}")
	private UserCtr userCtr;

	@EJB
	private StadiumServicesLocal stadiumServicesLocal;
	@EJB
	private BookingServicesLocal bookingServicesLocal;

	public String showSelectedStadium() {
		stadiumSelected = datamodel.getRowData();
		userConnected = userCtr.getUser();
		System.out.println(stadiumSelected.getLibele());
		System.out.println(userConnected.getName());
		bookingServicesLocal.bookStadium(userConnected, stadiumSelected,
				new Date());
		return "";
	}

	public List<Stadium> getStadiums() {
		stadiums = stadiumServicesLocal.findAllStadiums();
		return stadiums;
	}

	public void setStadiums(List<Stadium> stadiums) {
		this.stadiums = stadiums;
	}

	public DataModel<Stadium> getDatamodel() {
		datamodel.setWrappedData(stadiumServicesLocal.findAllStadiums());
		return datamodel;
	}

	public void setDatamodel(DataModel<Stadium> datamodel) {
		this.datamodel = datamodel;
	}

	public UserCtr getUserCtr() {
		return userCtr;
	}

	public void setUserCtr(UserCtr userCtr) {
		this.userCtr = userCtr;
	}

}
