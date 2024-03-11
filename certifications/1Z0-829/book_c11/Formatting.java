package book_c11;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatting {
    public static void main(String[] args) {
        double d = 1234.345;
        NumberFormat f1 = new DecimalFormat("$###,###,###.##");// 2 values round by default
        System.out.println(f1.format(d));
    }
}
