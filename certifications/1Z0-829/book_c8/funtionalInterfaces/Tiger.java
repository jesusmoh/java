package book_c8.funtionalInterfaces;

public class Tiger implements Sprint {

    @Override
    public void sprint(int speed) {
        System.out.println("speed=" + speed);
    }

}
