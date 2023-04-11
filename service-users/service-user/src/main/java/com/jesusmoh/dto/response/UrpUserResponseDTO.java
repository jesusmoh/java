package com.jesusmoh.dto.response;

import lombok.Data;

@Data
public class UrpUserResponseDTO {
	private Long oid;
	private String email;
	private String firstName;
	private String lastName;
	private String userName;
	private String description;
}
