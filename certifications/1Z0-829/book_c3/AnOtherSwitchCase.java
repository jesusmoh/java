public class AnOtherSwitchCase {

  enum Ele {
    GOLD, IRON, ZINK, SILVER
  }

  public static void main(String[] args) {

    Ele e = Ele.IRON;

    int i = switch (e) {
      case IRON -> {
        System.out.println("IRON");
        yield 1;
      }
      default -> {
        System.out.println("IRON");
        yield 0;
      }
    };

    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    for (String car : cars) {
      System.out.println(car);
    }

  }

}
