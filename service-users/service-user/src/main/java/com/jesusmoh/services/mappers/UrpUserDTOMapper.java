package com.jesusmoh.services.mappers;



import org.springframework.stereotype.Service;

import com.jesusmoh.dto.response.UrpUserDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;
import com.jesusmoh.persistence.entities.UrpUser;
import com.jesusmoh.persistence.projections.IUrpWeakUser;

@Service
public class UrpUserDTOMapper {

	public UrpUserDTO userDTOMapper(UrpUser u) {
		
		UrpUserDTO r= new UrpUserDTO();
		r.setEmail(u.getEmail());
		r.setFirstName(u.getFirstName());
		r.setLastName(u.getLastName());
		
		return r;
	
		
	}
	
public UrpWeakUserDTO weakUsersDTO (IUrpWeakUser u) {
		
	    UrpWeakUserDTO r= new UrpWeakUserDTO();
		r.setIssuedDate(u.getIssuedDate());
		r.setUserName(u.getUserName());
		r.setWeak(u.getWeak());
		return r;
	}
	
}
