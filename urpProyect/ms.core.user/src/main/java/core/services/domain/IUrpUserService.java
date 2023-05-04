package core.services.domain;

import java.util.List;

import core.dto.request.UrpUserRequestDTO;
import core.dto.response.UrpUserResponseDTO;
import core.dto.response.UrpWeakUserDTO;

public interface IUrpUserService {
	
	UrpUserResponseDTO getUrpUserByUserName(String userName);

	UrpWeakUserDTO weakUserDTO();
	
	List<UrpUserResponseDTO> findAll();
	
	UrpUserResponseDTO save(UrpUserRequestDTO  u);
	
	UrpUserResponseDTO delete(String username);
	
	UrpUserResponseDTO update(UrpUserRequestDTO u,String username);
	
	

}
