package com.jesusmoh.persistence.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;


/**
 * The persistent class for the urp_roles database table.
 * 
 */
@Entity
@Table(name="urp_roles")
public class UrpRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	private String description;

	private byte eliminated;

	private String group1dc;

	private String name;
	
	//bi-directional many-to-one association to UrpPrivilege
	@OneToMany(mappedBy="urpRole",fetch = FetchType.EAGER)
	private Set<UrpPrivilege> urpPrivileges;

	public UrpRole() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEliminated() {
		return this.eliminated;
	}

	public void setEliminated(byte eliminated) {
		this.eliminated = eliminated;
	}

	public String getGroup1dc() {
		return this.group1dc;
	}

	public void setGroup1dc(String group1dc) {
		this.group1dc = group1dc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<UrpPrivilege> getUrpPrivileges() {
		return urpPrivileges;
	}

	public void setUrpPrivileges(Set<UrpPrivilege> urpPrivileges) {
		this.urpPrivileges = urpPrivileges;
	}



}