package core.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import core.services.broker.events.CustomerCreatedEvent;
import core.services.broker.events.Event;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class
CustomerEventsService {
	static final Logger log = Logger.getLogger(CustomerEventsService.class.getName());

	@KafkaListener(
			topics = "${topic.customer.name:newUsersTopicV2}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(CustomerCreatedEvent.class)) {
			CustomerCreatedEvent customerCreatedEvent = (CustomerCreatedEvent) event;


			log.log(Level.INFO, "Received Customer created event .... with Id={}, data={}"+customerCreatedEvent.getId()+" "+customerCreatedEvent.getData().toString());


		}

	}
	
	

}
