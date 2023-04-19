package com.jesusmoh.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jesusmoh.dto.request.UrpUserRequestDTO;
import com.jesusmoh.dto.response.UrpResponseDTO;
import com.jesusmoh.dto.response.UrpUserResponseDTO;
import com.jesusmoh.services.domain.IUrpUserService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class UrpUserRestController {

	@Autowired
	@Qualifier("urpUserServiceImpl")
	private IUrpUserService urpUserService;


    //CRUD USER
	@GetMapping(value = "/{username}")
	public UrpResponseDTO getUrpUserByUserName(@PathVariable String username) {
		UrpResponseDTO r = new UrpResponseDTO(urpUserService.getUrpUserByUserName(username), null, HttpStatus.OK);
		return r;
	}
	
	@PutMapping(value = "/{username}")
	public UrpUserResponseDTO update(@RequestBody UrpUserRequestDTO dto,@PathVariable String username) {
		UrpUserResponseDTO r = urpUserService.update(dto,username);
		return r;

	}
	
	@PostMapping(value = "/")
	public UrpUserResponseDTO create(@RequestBody UrpUserRequestDTO dto) {
		UrpUserResponseDTO r = urpUserService.save(dto);
		return r;

	}

	@GetMapping("/")
	public UrpResponseDTO getAll() {
		List<UrpUserResponseDTO> l=urpUserService.findAll();
		UrpResponseDTO r = new UrpResponseDTO(l, null, HttpStatus.OK);
		return r;
	}

}