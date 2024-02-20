public interface IsColdBlooded {
   
    boolean hasScales();

    default double getT() {
        return 10.0;
    }
}
