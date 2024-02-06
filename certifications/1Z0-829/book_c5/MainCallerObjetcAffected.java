public class MainCallerObjetcAffected {

  public static void main(String[] args) {
    // Creating an object reference
    MyClass obj = new MyClass();

    // Calling a method on the object reference
    obj.modifyValue();

    // Accessing the modified value from the caller
    System.out.println(obj.value); // Output: 20
  }
}

class MyClass {

  int value;

  public MyClass() {
    this.value = 10;
  }

  // Method that modifies the value
  public void modifyValue() {
    this.value = 20;
  }
}
