package com.jesusmoh.services.domain.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jesusmoh.commons.UrpConstants;
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
	log.log(Level.INFO, r.toString());
	return r;

    }

    @Override
    public UrpWeakUserDTO weakUserDTO() {
	IUrpWeakUser i = userRepository.findWeakUser();
	UrpWeakUserDTO r = urpUserMapper.weakUsersDTO(i);
	log.log(Level.INFO, r.toString());
	return r;

    }

    @Override
    public List<UrpUserResponseDTO> findAll() {
	try {
	    List<UrpUser> l = userRepository.findAll();
	    log.log(Level.INFO, l.toString());
	    return urpUserMapper.userDTOMapper(l);
	} catch (UrpException e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(e.getMessage(), true);
	} catch (Exception e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(UrpConstants.SERVICE_ERROR, true);
	}
    }

    @Override
    public UrpUserResponseDTO save(UrpUserRequestDTO u) {

	try {
	    ValidateResultDTO v = urpUserValidatorService.isUrpUserValid(u);
	    if (v.isValid()) {
		UrpUserResponseDTO r;
		UrpUser t = userRepository.save(urpUserMapper.userMapper(u));
		r = urpUserMapper.userDTOMapper(t);
		log.log(Level.INFO, r.toString());
		return r;
	    } else {
		throw new UrpException(v.getResult(), true);
	    }

	} catch (UrpException e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(e.getMessage(), true);
	} catch (Exception e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(UrpConstants.SERVICE_ERROR, true);
	}

    }

    @Override
    public UrpUserResponseDTO delete(String username) {
	userRepository.deleteByUserName(username);
	return null;
    }

    @Override
    public UrpUserResponseDTO update(UrpUserRequestDTO u, String username) {
	try {
	    ValidateResultDTO v = urpUserValidatorService.isUrpUserValid(u);
	    UrpUserResponseDTO r = null;
	    if (v.isValid()) {
		UrpUser o = userRepository.findByUserName(username);
		u.setOid(o.getOid());
		if (o != null) {
		    Optional<UrpUser> l = userRepository.findById(o.getOid());
		    if (l.isPresent()) {
			o = urpUserMapper.userMapper(u);
			r = urpUserMapper.userDTOMapper(userRepository.save(o));
		    }
		}
		log.log(Level.INFO, r.toString());
		return r;

	    } else {
		throw new UrpException(v.getResult(), true);
	    }
	} catch (UrpException e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(e.getMessage(), true);
	} catch (Exception e) {
	    log.log(Level.SEVERE, e.getMessage());
	    throw new UrpException(UrpConstants.SERVICE_ERROR, true);
	}
    }

}
