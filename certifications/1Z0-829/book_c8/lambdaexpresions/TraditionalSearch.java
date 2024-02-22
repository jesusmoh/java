package book_c8.lambdaexpresions;

import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {

    public static void main(String[] args) {

        // list of animals
        var animals = new ArrayList<Animal>();

        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        // print(animals, new CheckIfHopper());

        // print(animals, a -> a.canHop());

        print(animals, (Animal a) -> {
            return a.canHop();
        });

        // All cases works beacause java infer one to one betewn metoshd

    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {

            if (checker.test(animal)) {
                System.out.println(animal + " ||| ");

            }
            System.out.println("");
        }
    }

}
