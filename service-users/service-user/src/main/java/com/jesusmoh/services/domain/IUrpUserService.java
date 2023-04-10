package com.jesusmoh.services.domain;

import com.jesusmoh.dto.response.UrpUserDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;

public interface IUrpUserService {
	
	UrpUserDTO getUrpUserByUserName(String userName);

	UrpWeakUserDTO weakUserDTO();

}
