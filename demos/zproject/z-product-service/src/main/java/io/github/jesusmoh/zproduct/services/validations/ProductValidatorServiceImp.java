package io.github.jesusmoh.zproduct.services.validations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.github.jesusmoh.zproduct.model.dto.ProductDTO;
import io.github.jesusmoh.zproduct.model.dto.common.ValidatorResultDTO;
import lombok.Data;

@Service
@Data
public class ProductValidatorServiceImp implements IProductValidatorService {

    @Value("${validator.product.name.regex}")
    private String validatorProductNameRegex;

    @Value("${validator.product.price.regex}")
    private String validatorProductPriceRegex;

    @Value("${validator.product.name.message}")
    private String validatorProductNameMessage;

    @Value("${validator.product.price.message}")
    private String validatorProductPriceMessage;

    private ValidatorResultDTO validateField(String fieldValue, String fieldRegex, String fieldMessage) {
        ValidatorResultDTO result = new ValidatorResultDTO();
        result.setValid(fieldValue.matches(fieldRegex));
        result.setResult((!result.isValid()) ? fieldMessage.concat(" >> ").concat(fieldValue) : "");
        return result;
    }

    public ValidatorResultDTO checkNameValid(String name) {
        return validateField(name, validatorProductNameRegex, validatorProductNameMessage);
    }

    public ValidatorResultDTO checkPriceValid(Double price) {
        return validateField(String.valueOf(price), validatorProductPriceRegex, validatorProductPriceMessage);
    }

    @Override
    public ValidatorResultDTO validate(ProductDTO dto) {

        var r = new ValidatorResultDTO();

        if (dto != null) {
            r = checkNameValid(dto.getName());
            if (!r.isValid())
                return r;

            r = checkPriceValid(dto.getPrice());
            if (!r.isValid())
                return r;

        }
        return r;

    }

}
