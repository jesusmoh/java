package core.services.broker.events;

import lombok.Data;

@Data
public abstract class Event <T> {
    private String id;
    private EventType type;
    private T data;
}
