package book_c7.encapsulation;

public final class CraneEncapsulationAndImutable {

    private final int numberEggs;
    private final String name;

    public CraneEncapsulationAndImutable(int numberEggs, String name) {
        this.numberEggs = numberEggs;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumberEggs() {
        return numberEggs;
    }

}
