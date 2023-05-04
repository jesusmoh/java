package com.jesusmoh.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the urp_permissionentities database table.
 * 
 */
@Entity
@Table(name="urp_permissionentities")
public class UrpPermissionentity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	private byte general;

	private String name;

	//bi-directional many-to-one association to UrpPrivilege
	@OneToMany(mappedBy="urpPermissionentity")
	private Set<UrpPrivilege> urpPrivileges;

	public UrpPermissionentity() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public byte getGeneral() {
		return this.general;
	}

	public void setGeneral(byte general) {
		this.general = general;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<UrpPrivilege> getUrpPrivileges() {
//		return this.urpPrivileges;
//	}
//
	public void setUrpPrivileges(Set<UrpPrivilege> urpPrivileges) {
		this.urpPrivileges = urpPrivileges;
	}

	public UrpPrivilege addUrpPrivilege(UrpPrivilege urpPrivilege) {
		this.urpPrivileges.add(urpPrivilege);
		urpPrivilege.setUrpPermissionentity(this);

		return urpPrivilege;
	}

	public UrpPrivilege removeUrpPrivilege(UrpPrivilege urpPrivilege) {
		this.urpPrivileges.remove(urpPrivilege);
		urpPrivilege.setUrpPermissionentity(null);

		return urpPrivilege;
	}

}