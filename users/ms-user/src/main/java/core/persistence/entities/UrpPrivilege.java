package core.persistence.entities;


import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the urp_privileges database table.
 * 
 */
@Entity
@Table(name="urp_privileges")
public class UrpPrivilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	private String permission;

	//bi-directional many-to-one association to UrpPermissionentity
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="permission_entity_id")
	private UrpPermissionentity urpPermissionentity;

	//bi-directional many-to-one association to UrpRole
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private UrpRole urpRole;

	public UrpPrivilege() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public UrpPermissionentity getUrpPermissionentity() {
		return this.urpPermissionentity;
	}

	public void setUrpPermissionentity(UrpPermissionentity urpPermissionentity) {
		this.urpPermissionentity = urpPermissionentity;
	}



}