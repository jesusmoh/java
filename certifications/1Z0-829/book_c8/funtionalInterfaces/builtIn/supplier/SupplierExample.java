package book_c8.funtionalInterfaces.builtIn.supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 5; i++) {
                sb.append("Number: ").append(i).append("\n");
            }
            return sb.toString();
        };

        String result = supplier.get();
        System.out.println(result);
    }
}
