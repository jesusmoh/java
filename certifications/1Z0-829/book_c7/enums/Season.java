package book_c7.enums;

public enum Season {
    WINTER("low");

    private OnlyOne(boolean b){
        System.out.println(""+b);
    }
}
