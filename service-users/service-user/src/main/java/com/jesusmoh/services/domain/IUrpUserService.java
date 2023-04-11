package com.jesusmoh.services.domain;

import java.util.List;

import com.jesusmoh.dto.request.UrpUserRequestDTO;
import com.jesusmoh.dto.response.UrpUserResponseDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;

public interface IUrpUserService {
	
	UrpUserResponseDTO getUrpUserByUserName(String userName);

	UrpWeakUserDTO weakUserDTO();
	
	List<UrpUserResponseDTO> findAll();
	
	UrpUserResponseDTO save(UrpUserRequestDTO  u);
	
	UrpUserResponseDTO delete(String username);
	
	UrpUserResponseDTO update(UrpUserRequestDTO u);
	
	

}
