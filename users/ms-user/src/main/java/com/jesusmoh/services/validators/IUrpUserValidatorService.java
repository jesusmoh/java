package com.jesusmoh.services.validators;

import com.jesusmoh.dto.ValidateResultDTO;
import com.jesusmoh.dto.request.UrpUserRequestDTO;

public interface IUrpUserValidatorService {

	ValidateResultDTO isUserNameValid(String userName);
	 
	ValidateResultDTO isUrpUserValid(UrpUserRequestDTO dto);


}
