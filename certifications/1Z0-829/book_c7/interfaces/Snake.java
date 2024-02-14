package book_c7.interfaces;

public class Snake implements IsColdBlooded {

    @Override
    public boolean hasScales() {
        // TODO Auto-generated method stub
        return (getT() > 0);
    }

}
