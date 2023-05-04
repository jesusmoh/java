package core.services.broker.events;

import lombok.Data;

@Data
public abstract class Event <UrpUserRequestDTO> {
    private String id;
    private EventType type;
    private UrpUserRequestDTO data;
}
