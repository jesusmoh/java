package com.jesusmoh.services.validators.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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


	public boolean isUserNameValid(String userName) {
        return userName.matches(validatorUserNameRegex);
    }
}
