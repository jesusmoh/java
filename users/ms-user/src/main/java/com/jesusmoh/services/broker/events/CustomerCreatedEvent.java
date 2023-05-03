package com.jesusmoh.services.broker.events;

import com.jesusmoh.dto.request.UrpUserRequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<UrpUserRequestDTO> {

}
