package core.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import core.persistence.entities.UrpGroup;
import core.persistence.entities.UrpRole;
import lombok.Data;

@Data
public class UrpUserResponseDTO {
	private Long oid;
	private String email;
	private String firstName;
	private String lastName;
	private String userName;
	private String description;
	private int commerceId;
	private Set<UrpRole> urpRoles;
	private int groupId;
	private UrpGroup urpGroup;
}
