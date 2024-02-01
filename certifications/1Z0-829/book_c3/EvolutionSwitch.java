
public class EvolutionSwitch {

  enum CardType {
    SILVER, GOLD, PLATINUM, DIAMOND,
  }

  private static Double getOrderDiscountFormula2(CardType cardType) {
    Double result;
    // switch expresion
    result = switch (cardType) {
      case SILVER -> {
        System.out.println("SMS");
        yield 10.5;
      }
      case GOLD -> 11.5;
      case PLATINUM -> 12.5;
      case DIAMOND -> 13.5;
    };
    return result;
  }

  private static Double getOrderDiscountFormula(CardType cardType) {
    Double result;
    // switch statement
    switch (cardType) {
      case SILVER:
        System.out.println("SMS");
        result = 10.5;
        break;
      case GOLD:
        result = 11.5;
        break;
      case PLATINUM:
        result = 12.5;
        break;
      case DIAMOND:
        result = 13.5;
        break;
      default:
        throw new IllegalArgumentException("Unexpected value: " + cardType);
    }
    return result;
  }

  public static void main(String[] args) {}
}
