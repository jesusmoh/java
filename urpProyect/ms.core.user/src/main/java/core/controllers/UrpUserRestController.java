package core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.dto.request.UrpUserRequestDTO;
import core.dto.response.UrpResponseDTO;
import core.dto.response.UrpUserResponseDTO;
import core.services.domain.IUrpUserService;

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
		return new UrpResponseDTO(urpUserService.getUrpUserByUserName(username), null, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{username}")
	public UrpUserResponseDTO update(@RequestBody UrpUserRequestDTO dto,@PathVariable String username) {
		return urpUserService.update(dto,username);

	}
	
	@PostMapping(value = "/")
	public UrpUserResponseDTO create(@RequestBody UrpUserRequestDTO dto) {
		return urpUserService.save(dto);

	}

	@GetMapping("/")
	public UrpResponseDTO getAll() {
		List<UrpUserResponseDTO> l=urpUserService.findAll();
		return new UrpResponseDTO(l, null, HttpStatus.OK);
	}

}