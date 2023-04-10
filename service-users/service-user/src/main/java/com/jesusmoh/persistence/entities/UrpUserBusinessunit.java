package com.jesusmoh.persistence.entities;


import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the urp_user_businessunits database table.
 * 
 */
@Entity
@Table(name="urp_user_businessunits")
@NamedQuery(name="UrpUserBusinessunit.findAll", query="SELECT u FROM UrpUserBusinessunit u")
public class UrpUserBusinessunit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="business_unit_id")
	private String businessUnitId;

	//bi-directional many-to-one association to UrpUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private UrpUser urpUser;

	public UrpUserBusinessunit() {
	}

	public String getBusinessUnitId() {
		return this.businessUnitId;
	}

	public void setBusinessUnitId(String businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public UrpUser getUrpUser() {
		return this.urpUser;
	}

	public void setUrpUser(UrpUser urpUser) {
		this.urpUser = urpUser;
	}

}