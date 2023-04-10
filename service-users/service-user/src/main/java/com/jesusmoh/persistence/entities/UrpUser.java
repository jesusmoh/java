package com.jesusmoh.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the urp_users database table.
 * 
 */
@Entity
@Table(name="urp_users")
public class UrpUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	@Column(name="commerce_id")
	private BigInteger commerceId;

	private String description;

	private byte eliminated;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UrpUserBusinessunit
	@OneToMany(mappedBy="urpUser")
	private Set<UrpUserBusinessunit> urpUserBusinessunits;

	//bi-directional many-to-many association to UrpRole
	@ManyToMany
	@JoinTable(
		name="urp_user_roles"
		, joinColumns={
			@JoinColumn(name="user_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rol_id")
			}
		)
	private Set<UrpRole> urpRoles;

	//bi-directional many-to-one association to UrpGroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private UrpGroup urpGroup;

	public UrpUser() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public BigInteger getCommerceId() {
		return this.commerceId;
	}

	public void setCommerceId(BigInteger commerceId) {
		this.commerceId = commerceId;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UrpUserBusinessunit> getUrpUserBusinessunits() {
		return this.urpUserBusinessunits;
	}

	public void setUrpUserBusinessunits(Set<UrpUserBusinessunit> urpUserBusinessunits) {
		this.urpUserBusinessunits = urpUserBusinessunits;
	}

	public UrpUserBusinessunit addUrpUserBusinessunit(UrpUserBusinessunit urpUserBusinessunit) {
		getUrpUserBusinessunits().add(urpUserBusinessunit);
		urpUserBusinessunit.setUrpUser(this);

		return urpUserBusinessunit;
	}

	public UrpUserBusinessunit removeUrpUserBusinessunit(UrpUserBusinessunit urpUserBusinessunit) {
		getUrpUserBusinessunits().remove(urpUserBusinessunit);
		urpUserBusinessunit.setUrpUser(null);

		return urpUserBusinessunit;
	}

	public Set<UrpRole> getUrpRoles() {
		return this.urpRoles;
	}

	public void setUrpRoles(Set<UrpRole> urpRoles) {
		this.urpRoles = urpRoles;
	}

	public UrpGroup getUrpGroup() {
		return this.urpGroup;
	}

	public void setUrpGroup(UrpGroup urpGroup) {
		this.urpGroup = urpGroup;
	}

}