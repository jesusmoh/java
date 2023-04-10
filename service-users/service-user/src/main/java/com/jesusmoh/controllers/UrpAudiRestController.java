package com.jesusmoh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jesusmoh.dto.response.UrpWeakUserDTO;
import com.jesusmoh.services.domain.IUrpUserService;

@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
public class UrpAudiRestController {
	
	@Autowired
    @Qualifier("urpUserServiceImpl")
    private IUrpUserService urpUserService;

    @GetMapping(value = "/weakusers/")
    public UrpWeakUserDTO t() {
        return urpUserService.weakUserDTO();
    }

}
