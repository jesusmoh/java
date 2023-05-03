package com.jesusmoh.entity;

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
	private int groupId;
}
