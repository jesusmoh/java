package core.persistence.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the urp_validation_user database table.
 * 
 */
@Entity
@Table(name="urp_validation_user")
@NamedQuery(name="UrpValidationUser.findAll", query="SELECT u FROM UrpValidationUser u")
public class UrpValidationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	private byte blocked;

	@Column(name="failed_attempts")
	private int failedAttempts;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_session")
	private Date lastSession;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="user_activation")
	private Date userActivation;

	@Column(name="user_id")
	private BigInteger userId;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UrpPassword
	@OneToMany(mappedBy="urpValidationUser")
	private Set<UrpPassword> urpPasswords;

	//bi-directional many-to-one association to UrpPassword
	@ManyToOne
	@JoinColumn(name="current_password_id")
	private UrpPassword urpPassword;

	public UrpValidationUser() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public byte getBlocked() {
		return this.blocked;
	}

	public void setBlocked(byte blocked) {
		this.blocked = blocked;
	}

	public int getFailedAttempts() {
		return this.failedAttempts;
	}

	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public Date getLastSession() {
		return this.lastSession;
	}

	public void setLastSession(Date lastSession) {
		this.lastSession = lastSession;
	}

	public Date getUserActivation() {
		return this.userActivation;
	}

	public void setUserActivation(Date userActivation) {
		this.userActivation = userActivation;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<UrpPassword> getUrpPasswords() {
		return this.urpPasswords;
	}

	public void setUrpPasswords(Set<UrpPassword> urpPasswords) {
		this.urpPasswords = urpPasswords;
	}

	public UrpPassword addUrpPassword(UrpPassword urpPassword) {
		getUrpPasswords().add(urpPassword);
		urpPassword.setUrpValidationUser(this);

		return urpPassword;
	}

	public UrpPassword removeUrpPassword(UrpPassword urpPassword) {
		getUrpPasswords().remove(urpPassword);
		urpPassword.setUrpValidationUser(null);

		return urpPassword;
	}

	public UrpPassword getUrpPassword() {
		return this.urpPassword;
	}

	public void setUrpPassword(UrpPassword urpPassword) {
		this.urpPassword = urpPassword;
	}

}