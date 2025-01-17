package Concepts.Inheritance; // Same package as parent class

// Dog class - Child to class Animal
public class Dog extends Animal{
    // Additional attributes specific to Dog class
    private String breed;

    public Dog(String name) {
        super(name); // Calls parent constructor
    }

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public void bark() {
        System.out.println(name + " is barking");
    }

    // Getter and setter for breed
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
