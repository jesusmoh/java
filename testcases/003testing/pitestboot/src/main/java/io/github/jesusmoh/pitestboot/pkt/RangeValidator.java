package io.github.jesusmoh.pitestboot.pkt;

class RangeValidator {

  boolean isValid(int input) {
    return input > 0 && input <= 100;
  }
}
