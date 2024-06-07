package io.github.jesusmoh.zorder.model.record;

public record OrderPlacedDTO(float total, int orderNumber, String status, String description) {
}