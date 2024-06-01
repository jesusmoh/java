package io.github.jesusmoh.zproduct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;

@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelcastIniConfig() {
        Config config = new Config();
        config.setInstanceName("z-product-service-instance")
                .addMapConfig(
                        new MapConfig()
                                .setName("my-distributed-map")
                                .setStatisticsEnabled(true));

        // Enable Multicast
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(true);

        return config;
    }
}
