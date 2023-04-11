package com.jesusmoh.services.validators.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jesusmoh.dto.ValidateResultDTO;
import com.jesusmoh.dto.request.UrpUserRequestDTO;
import com.jesusmoh.services.validators.IUrpUserValidatorService;

import lombok.Data;

@Service
@Data
public class UrpUserValidatorServiceImpl implements IUrpUserValidatorService {

	@Value("${validator.user.name.regex}")
    private String validatorUserNameRegex;

    @Value("${validator.user.name.messages}")
    private String validatorUserNameMessages;

    @Value("${validator.first.name.regex}")
    private String validatorFirstNameRegex;

    @Value("${validator.first.name.messages}")
    private String validatorFirstNameMessages;

    @Value("${validator.last.name.regex}")
    private String validatorLastNameRegex;

    @Value("${validator.last.name.messages}")
    private String validatorLastNameMessages;

    @Value("${validator.api.email.regex}")
    private String validatorApiEmailRegex;

    @Value("${validator.api.email.messages}")
    private String validatorApiEmailMessages;


	public ValidateResultDTO isUserNameValid(String userName) {
		ValidateResultDTO r = new ValidateResultDTO();
		r.setValid(userName.matches(validatorUserNameRegex));
		r.setResult((r.isValid() == false) ? validatorUserNameMessages.concat(" >> ".concat(userName)) :"");
		return r;
	}


	@Override
	public ValidateResultDTO isUrpUserValid(UrpUserRequestDTO dto) {
		ValidateResultDTO r = new ValidateResultDTO();
		
		if(dto!=null) {
			r =isUserNameValid(dto.getUserName());
			if(r.isValid()==false)
				return r;
			
		}
		
		return r;
	}
}
