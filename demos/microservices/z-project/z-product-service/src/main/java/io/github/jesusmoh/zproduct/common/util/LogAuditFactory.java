package io.github.jesusmoh.zproduct.common.util;

import java.util.UUID;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class LogAuditFactory {

    public static String getKey() {
        final UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static MultiValueMap<String, String> buildLogAudit(String uuid) {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("uuid", uuid);
        return multiValueMap;
    }

}
