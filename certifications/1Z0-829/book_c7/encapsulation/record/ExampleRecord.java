package book_c7.encapsulation.record;

public class ExampleRecord {

    // Basic example
    public record Example(int i, int t) {
    }

    // DTO
    public record ExampleDTO(int i, int t) {
    }

    // API respose
    public record apiResponse(int i, String r) {
    }

    // Configuration
    public record AppConfig(String appName, int version) {
    }

    // Overriden Records
    public record mySpciealDTO(int numberx, String stringx) {
        @Override
        public int numberx() {
            return 99;
        }
    }

    public static void main(String[] args) {

        var t = new Example(0, 0);
        System.out.println(t.toString());

        var t2 = new ExampleDTO(2, 2);
        System.out.println(t2.toString());

        var t3 = new apiResponse(404, "404");
        System.out.println(t3.toString());

        var t4 = new AppConfig("404", 2);
        System.out.println(t4.toString());

        var t5 = new mySpciealDTO(404, "032");
        System.out.println(t5.numberx);
    }
}
