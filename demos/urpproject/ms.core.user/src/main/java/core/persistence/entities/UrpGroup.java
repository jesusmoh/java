package core.persistence.entities;
import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Set;


/**
 * The persistent class for the urp_groups database table.
 * 
 */
@Entity
@Table(name="urp_groups")
public class UrpGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;

	private String name;

	//bi-directional many-to-one association to UrpUser
	@OneToMany(mappedBy="urpGroup")
	private Set<UrpUser> urpUsers;

	public UrpGroup() {
	}

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrpUsers(Set<UrpUser> urpUsers) {
		this.urpUsers = urpUsers;
	}

}