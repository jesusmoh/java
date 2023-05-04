package com.jesusmoh.dto.request;

import lombok.Data;

@Data
public class UrpUserRequestDTO {
	private Long oid;
	private String email;
	private String firstName;
	private String lastName;
	private String userName;
	private String description;
	
	
}
