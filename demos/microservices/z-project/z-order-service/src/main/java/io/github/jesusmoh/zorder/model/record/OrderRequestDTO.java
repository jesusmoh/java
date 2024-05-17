package io.github.jesusmoh.zorder.model.record;

public record OrderRequestDTO(Integer id, int orderNumber, String skuCode, float price, int quantity) {
}
