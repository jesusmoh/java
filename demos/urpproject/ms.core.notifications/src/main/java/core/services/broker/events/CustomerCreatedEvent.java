package core.services.broker.events;

import core.entity.UrpUserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<UrpUserDTO> {

}
