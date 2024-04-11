package core.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the urp_passwords database table.
 * 
 */
@Entity
@Table(name="urp_passwords")
public class UrpPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="issued_date")
	private Date issuedDate;

	private String text;

	//bi-directional many-to-one association to UrpValidationUser
	@ManyToOne
	@JoinColumn(name="password_oid")
	private UrpValidationUser urpValidationUser;
	
	@Column(name="weak")
	private int weak;

	//bi-directional many-to-one association to UrpValidationUser
	@OneToMany(mappedBy="urpPassword")
	private Set<UrpValidationUser> urpValidationUsers;

	public UrpPassword() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public Date getIssuedDate() {
		return this.issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UrpValidationUser getUrpValidationUser() {
		return this.urpValidationUser;
	}

	public void setUrpValidationUser(UrpValidationUser urpValidationUser) {
		this.urpValidationUser = urpValidationUser;
	}

	public Set<UrpValidationUser> getUrpValidationUsers() {
		return this.urpValidationUsers;
	}

	public void setUrpValidationUsers(Set<UrpValidationUser> urpValidationUsers) {
		this.urpValidationUsers = urpValidationUsers;
	}

	public UrpValidationUser addUrpValidationUser(UrpValidationUser urpValidationUser) {
		getUrpValidationUsers().add(urpValidationUser);
		urpValidationUser.setUrpPassword(this);

		return urpValidationUser;
	}

	public UrpValidationUser removeUrpValidationUser(UrpValidationUser urpValidationUser) {
		getUrpValidationUsers().remove(urpValidationUser);
		urpValidationUser.setUrpPassword(null);

		return urpValidationUser;
	}

	public int getWeak() {
		return weak;
	}

	public void setWeak(int weak) {
		this.weak = weak;
	}

}