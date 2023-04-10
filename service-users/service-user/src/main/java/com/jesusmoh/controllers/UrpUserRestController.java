package com.jesusmoh.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesusmoh.dto.response.UrpResponseDTO;
import com.jesusmoh.dto.response.UrpUserDTO;
import com.jesusmoh.services.domain.IUrpUserService;
import com.jesusmoh.services.validators.IUrpUserValidatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class UrpUserRestController {

	@Autowired
	@Qualifier("urpUserServiceImpl")
	private IUrpUserService urpUserService;

	@Autowired
	@Qualifier("urpUserValidatorServiceImpl")
	private IUrpUserValidatorService urpUserValidatorService;

	@GetMapping(value = "/{username}")
	public UrpResponseDTO getUrpUserByUserName(@PathVariable String username) {

		UrpResponseDTO r;
		if (urpUserValidatorService.isUserNameValid(username)) {
			UrpUserDTO u = urpUserService.getUrpUserByUserName(username);
			r = new UrpResponseDTO(u, null,HttpStatus.OK);
			return r;
		} else {
			r = new UrpResponseDTO(new UrpUserDTO(), null,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return r;

	}

}