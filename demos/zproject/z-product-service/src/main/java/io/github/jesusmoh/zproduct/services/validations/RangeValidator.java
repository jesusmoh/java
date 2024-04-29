package io.github.jesusmoh.zproduct.services.validations;

public class RangeValidator {

    public boolean isValid(int input) {
        return input > 0 && input <= 100;
    }
}