public class CasesIni {

    // var t=4;

    public static void main(String[] args) {
        int x;
        var d = new Dog();
        // d=45; error
        System.out.println("? " + d);
        d = null; // puede ponerle un null para que GC lo recoga
        d = new Dog();
        System.out.println("? " + d);
    }

    static class Dog {
    }
}
