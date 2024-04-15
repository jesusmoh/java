package io.github.jesusmoh.zproduct.model.dto.common;

import lombok.Data;

@Data
public class ValidatorResultDTO {
    private boolean valid;
    private String result;
}
