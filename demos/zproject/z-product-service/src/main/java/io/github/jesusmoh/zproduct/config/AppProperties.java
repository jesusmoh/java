package io.github.jesusmoh.zproduct.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
    private String bootstrapServer;
    private String clientId;
    private String groupId;

}
