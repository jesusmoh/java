package core.services.validators.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import core.dto.ValidateResultDTO;
import core.dto.request.UrpUserRequestDTO;
import core.services.validators.IUrpUserValidatorService;
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


	public ValidateResultDTO isUserNameValid(String userName) {
		ValidateResultDTO r = new ValidateResultDTO();
		r.setValid(userName.matches(validatorUserNameRegex));
		r.setResult((r.isValid() == false) ? validatorUserNameMessages.concat(" >> ".concat(userName)) :"");
		return r;
	}

	public ValidateResultDTO isFirstNameValid(String firstName) {
		ValidateResultDTO r = new ValidateResultDTO();
		r.setValid(firstName.matches(validatorFirstNameRegex));
		r.setResult((r.isValid() == false) ? validatorUserNameMessages.concat(" >> ".concat(firstName)) :"");
		return r;
	}
	
	public ValidateResultDTO isLastNameValid(String lastName) {
		ValidateResultDTO r = new ValidateResultDTO();
		r.setValid(lastName.matches(validatorLastNameRegex));
		r.setResult((r.isValid() == false) ? validatorUserNameMessages.concat(" >> ".concat(lastName)) :"");
		return r;
	}


	@Override
	public ValidateResultDTO isUrpUserValid(UrpUserRequestDTO dto) {
		ValidateResultDTO r = new ValidateResultDTO();
		
		if (dto != null) {
		    r = isUserNameValid(dto.getUserName());
		    if(!r.isValid())
			return r;
		    
		    r = isFirstNameValid(dto.getFirstName());
		    if(!r.isValid())
			return r;
		    
		    r = isLastNameValid(dto.getLastName());
		    if(!r.isValid())
			return r;

		}
		
		return r;
	}
}
