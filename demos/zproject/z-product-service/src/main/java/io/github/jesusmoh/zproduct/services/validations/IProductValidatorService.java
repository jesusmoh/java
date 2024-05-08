package io.github.jesusmoh.zproduct.services.validations;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.model.dto.ValidatorResultDTO;

public interface IProductValidatorService {

    ValidatorResultDTO validate(ProductDTO dto);
}
