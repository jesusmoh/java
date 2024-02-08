public class MainCallerObjetcAffected2 {

  public static void main(String[] args) {

    System.out.println("-------------------------------------");

    // CASE 1
    Rectangle rect = new Rectangle(10, 20);

    System.out.println("Initial position rect - x: " + rect.x + ", y: " + rect.y); // Output: Initial position - x: 10,
                                                                                   // y: 20
    // Calling a method and passing new values(UPDATE)
    modifyRectangle(rect);
    // Accessing the modified state from the caller
    System.out.println("New position rect - x: " + rect.x + ", y: " + rect.y); // Output: New position - x: 15, y: 25

    System.out.println("-------------------------------------");

    // CASE 2
    Rectangle rectV1 = new Rectangle(10, 20);
    Rectangle rectV2 = new Rectangle(11, 21);

    System.out.println("Initial position rectV1 - x: " + rectV1.x + ", y: " + rectV1.y); // Output: Initial position -
                                                                                         // x: 10, y: 20
    swaping(rectV1, rectV2);
    // Accessing the modified??? state from the caller
    System.out.println("New position rectV1 - x: " + rectV1.x + ", y: " + rectV1.y); // Output: New position - x: 15, y:
                                                                                     // 25

    System.out.println("-------------------------------------");

    // CASE 3
    Rectangle rectV3 = new Rectangle(10, 20);

    System.out.println("Initial position rectV3 - x: " + rectV3.x + ", y: " + rectV3.y); // Output: Initial position -
                                                                                         // x: 10, y: 20
    modifyRectangleNewInstance(rectV3);
    // Accessing the modified??? state from the caller
    System.out.println("New position rectV3 - x: " + rectV3.x + ", y: " + rectV3.y); // Output: New position - x: 0, y:
                                                                                     // 0

  }

  // Method that modifies the state of the object
  public static void modifyRectangleNewInstance(Rectangle r) {
    r = new Rectangle(0, 0);
  }

  // Method that modifies the state of the object
  public static void modifyRectangle(Rectangle r) {
    r.x = 15;
    r.y = 25;
  }

  // Method that modifies objects by swaping
  public static void swaping(Rectangle r1, Rectangle r2) {
    Rectangle temp = r1;
    r1 = r2;
    r2 = temp;
    System.out.println(temp.x + " " + temp.y);
    // temp.x = 15;
    // r1.y = 25;
    // r2.x = 35;
    // r2.y = 45;
  }
}

class Rectangle {

  int x, y;

  public Rectangle(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
