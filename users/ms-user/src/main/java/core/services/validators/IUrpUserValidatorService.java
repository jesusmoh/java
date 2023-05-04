package core.services.validators;

import core.dto.ValidateResultDTO;
import core.dto.request.UrpUserRequestDTO;

public interface IUrpUserValidatorService {

	ValidateResultDTO isUserNameValid(String userName);
	 
	ValidateResultDTO isUrpUserValid(UrpUserRequestDTO dto);


}
