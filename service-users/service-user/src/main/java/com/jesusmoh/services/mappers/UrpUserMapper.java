package com.jesusmoh.services.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.jesusmoh.dto.request.UrpUserRequestDTO;
import com.jesusmoh.dto.response.UrpUserResponseDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;
import com.jesusmoh.persistence.entities.UrpUser;
import com.jesusmoh.persistence.projections.IUrpWeakUser;

@Service
public class UrpUserMapper {
	
	ModelMapper modelMapper = new ModelMapper();

	public UrpUserResponseDTO userDTOMapper(UrpUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UrpUserResponseDTO dto = modelMapper.map(u, UrpUserResponseDTO.class);
		return dto;
	}
	
	public List<UrpUserResponseDTO> userDTOMapper(List<UrpUser> l){		
		List<UrpUserResponseDTO> r= new  ArrayList<>();
		l.stream().forEach(x-> r.add(userDTOMapper(x)));
		return r;
	}

	public UrpWeakUserDTO weakUsersDTO(IUrpWeakUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UrpWeakUserDTO r = modelMapper.map(u, UrpWeakUserDTO.class);
		return r;
	}
	
	public UrpUser userMapper(UrpUserRequestDTO u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UrpUser r 	= modelMapper.map(u, UrpUser.class);
		return r;

	}
	
	public UrpUser userMapper(UrpUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		UrpUser r 	= modelMapper.map(u, UrpUser.class);
		return r;

	}

}
