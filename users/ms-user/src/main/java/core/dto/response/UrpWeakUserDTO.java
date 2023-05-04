package core.dto.response;

import java.util.Date;

import lombok.Data;

@Data
public class UrpWeakUserDTO {
	private String UserName;
	private Date IssuedDate;
	private int weak;

}
