public class OverloadingMethods {
    public static void main(String[] args) {

        myMethod(12.8f);// Infiere the funtion by type

    }

    static void myMethod(double x) {
        System.out.println("double");
    };

    static void myMethod(float x) {
        System.out.println("float");
    };

}
