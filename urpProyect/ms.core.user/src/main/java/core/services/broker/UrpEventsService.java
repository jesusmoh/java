package core.services.broker;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import core.dto.broker.UrpUserDTO;
import core.services.broker.events.*;

@Service
public class UrpEventsService {

	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.customer.name:newUsersTopicV2}")
	private String topicNewUrpUsers;
	
	public void publishCreate(UrpUserDTO dto) {

		CustomerCreatedEvent created = new CustomerCreatedEvent();
		created.setData(dto);
		created.setId(UUID.randomUUID().toString());
		created.setType(EventType.CREATED);
		this.producer.send(topicNewUrpUsers, created);
	}
}
