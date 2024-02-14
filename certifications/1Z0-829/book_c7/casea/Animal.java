package book_c7.casea;

//Thus, the main motivation behind sealed classes is to have the possibility for a superclass to be widely accessible but not widely extensible.
sealed class Animal permits Dog, Cat, Bird {
    // Class implementation
}

// whit final it doesn't permit sub clases
class final Dog extends Animal {
    // Class implementation
}

class Cat extends Animal {
    // Class implementation
}

class Bird extends Animal {
    // Class implementation
}

// This mark error beacuse it doesn't extend from animal
class Rock extends Animal {

}