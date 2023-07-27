package core.services.mappers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import core.dto.request.UrpUserRequestDTO;
import core.dto.response.UrpUserResponseDTO;
import core.dto.response.UrpWeakUserDTO;
import core.persistence.entities.UrpUser;
import core.persistence.projections.IUrpWeakUser;

@Service
public class UrpUserMapper {
	
	ModelMapper modelMapper = new ModelMapper();

	public UrpUserResponseDTO userDTOMapper(UrpUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(u, UrpUserResponseDTO.class);
	}
	
	public List<UrpUserResponseDTO> userDTOMapper(List<UrpUser> l){		
		List<UrpUserResponseDTO> r= new  ArrayList<>();
		l.stream().forEach(x-> r.add(userDTOMapper(x)));
		return r;
	}

	public UrpWeakUserDTO weakUsersDTO(IUrpWeakUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(u, UrpWeakUserDTO.class);
	}
	
	public UrpUser userMapper(UrpUserRequestDTO u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper.map(u, UrpUser.class);

	}
	
	public UrpUser userMapper(UrpUser u) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return  modelMapper.map(u, UrpUser.class);
		
	}

}
