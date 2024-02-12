package book_c6;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public Animal covariant() { // covariant
        System.out.println("Animal makes a sound");
        return new Animal();
    }
}

class Dog extends Animal {
    @Override // Explicty and Implicty @Override is optional....
    public void makeSound() {
        System.out.println("Dog barks");
    }

    @Override // Return other data type (only sons or other tree family)
    public Dog covariant() {
        System.out.println("Dog barks");
        return new Dog();
    }
}

public class OverWrittenMethods {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound(); // Output: Animal makes a sound

        Animal dog = new Dog();
        dog.makeSound(); // Output: Dog barks
    }
}
