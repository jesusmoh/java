package book_c6;

public class Reptile {
    static {
        System.out.println("Reptile");
    }
    protected float speed = 10.5f;

    public static void main(String[] args) {
        System.out.println("main");
        var cro = new Cro();
        System.out.println(cro.getSpeed());

    }
}

class Cro extends Reptile {
    static {
        System.out.println("Cro");
    }
    protected float speed = 10.6f;
    private int k;

    // The dafault contructor in a son class is this...Was wrote only to see. Is not
    // mandatoy
    public Cro() {
        super();
    };

    public float getSpeed() {
        return super.speed;// super
    }

    public int getK() {

        return this.k;
    }

}
