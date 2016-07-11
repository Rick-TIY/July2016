package week1.day1.zoo;

public class Dog extends Mammal {

    public Dog() {
        this.name = "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}
