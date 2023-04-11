package com.jesusmoh.services.domain.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jesusmoh.dto.ValidateResultDTO;
import com.jesusmoh.dto.request.UrpUserRequestDTO;
import com.jesusmoh.dto.response.UrpUserResponseDTO;
import com.jesusmoh.dto.response.UrpWeakUserDTO;
import com.jesusmoh.exceptions.UrpException;
import com.jesusmoh.persistence.entities.UrpUser;
import com.jesusmoh.persistence.projections.IUrpWeakUser;
import com.jesusmoh.persistence.repository.UrpUsersCrudRepository;
import com.jesusmoh.services.domain.IUrpUserService;
import com.jesusmoh.services.mappers.UrpUserMapper;
import com.jesusmoh.services.mappers.UrpUserMapper;
import com.jesusmoh.services.validators.IUrpUserValidatorService;

@Service
public class UrpUserServiceImpl implements IUrpUserService {

	static final Logger log = Logger.getLogger(UrpUserServiceImpl.class.getName());

	@Autowired
	private UrpUsersCrudRepository userRepository;

	@Autowired
	private UrpUserMapper urpUserMapper;

	@Autowired
	@Qualifier("urpUserValidatorServiceImpl")
	private IUrpUserValidatorService urpUserValidatorService;

	@Override
	public UrpUserResponseDTO getUrpUserByUserName(String userName) {

		UrpUserResponseDTO r = new UrpUserResponseDTO();
		UrpUser t = userRepository.findByUserName(userName);
		r = urpUserMapper.userDTOMapper(t);
		return r;

	}

	@Override
	public UrpWeakUserDTO weakUserDTO() {
		IUrpWeakUser i = userRepository.findWeakUser();
		UrpWeakUserDTO l = urpUserMapper.weakUsersDTO(i);
		return l;

	}

	@Override
	public List<UrpUserResponseDTO> findAll() {
		List<UrpUser> l = userRepository.findAll();
		return urpUserMapper.userDTOMapper(l);
	}

	@Override
	public UrpUserResponseDTO save(UrpUserRequestDTO u) {

		try {
			ValidateResultDTO v = urpUserValidatorService.isUrpUserValid(u);
			if (v.isValid()) {
				UrpUserResponseDTO r;
				UrpUser t = userRepository.save(urpUserMapper.userMapper(u));
				r = urpUserMapper.userDTOMapper(t);
				return r;
			} else {
				throw new UrpException(v.getResult(), true);
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new UrpException("Invalid username/password supplied 3", true);
		}

	}

	@Override
	public UrpUserResponseDTO delete(String username) {
		userRepository.deleteByUserName(username);
		return null;
	}

	@Override
	public UrpUserResponseDTO update(UrpUserRequestDTO u) {
		try {
			ValidateResultDTO v = urpUserValidatorService.isUrpUserValid(u);
			UrpUserResponseDTO r = null;
			if (v.isValid()) {
				Optional<UrpUser> o = userRepository.findById(u.getOid());
				if (o.isPresent()) {
					UrpUser t = urpUserMapper.userMapper(o.get());
					t = urpUserMapper.userMapper(u);
					r = urpUserMapper.userDTOMapper(userRepository.save(t));
				}
				return r;

			} else {
				throw new UrpException(v.getResult(), true);
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
			throw new UrpException("No se puedo actulizar", true);
		}
	}

}
