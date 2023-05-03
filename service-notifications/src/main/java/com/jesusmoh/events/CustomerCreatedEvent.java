package com.jesusmoh.events;

import com.jesusmoh.entity.UrpUserResponseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<UrpUserResponseDTO> {

}
