package book_c6;

import java.util.LinkedList;

public final class NoImmutuableFinalClass {
    final private int p = 1;
    final private LinkedList<String> l = new LinkedList<>();

    public LinkedList getL() {
        return l;
    }

    public int getP() {
        return p;
    }

    public static void main(String[] args) {
        var m = new NoImmutuableFinalClass();
        System.out.println(m.l.size());
        m.l.add("FakeImmutuable");
        System.out.println(m.l.size());// 1 The final word doesn't cover all

        final var b = new NoImmutuableFinalClass();
        System.out.println(b.l.size());
        b.l.add("FakeImmutuable1");
        b.l.add("FakeImmutuable2");
        System.out.println(b.l.size());// 1 The final word doesn't cover all
    }
}
