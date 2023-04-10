package com.jesusmoh.services.domain.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusmoh.dto.response.UrpUserDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;
import com.jesusmoh.persistence.entities.UrpUser;
import com.jesusmoh.persistence.projections.IUrpWeakUser;
import com.jesusmoh.persistence.repository.UrpUsersCrudRepository;
import com.jesusmoh.services.domain.IUrpUserService;
import com.jesusmoh.services.mappers.UrpUserDTOMapper;

@Service
public class UrpUserServiceImpl implements IUrpUserService{

    @Autowired
    private UrpUsersCrudRepository userRepository;
    
    @Autowired
    private UrpUserDTOMapper urpUserDTOMapper;

	@Override
	public UrpUserDTO getUrpUserByUserName(String userName) {
		
		UrpUserDTO r= new UrpUserDTO();
		UrpUser t=userRepository.findByUserName(userName);
		r=urpUserDTOMapper.userDTOMapper(t);
		return r;
		
	}

	@Override
	public UrpWeakUserDTO weakUserDTO() {
		UrpWeakUserDTO l;
		IUrpWeakUser i=userRepository.findWeakUser();
		return  l=urpUserDTOMapper.weakUsersDTO(i);
		
	}


	

}
