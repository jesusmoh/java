package core.services.broker.events;

import core.dto.request.UrpUserRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<UrpUserRequestDTO> {

}
