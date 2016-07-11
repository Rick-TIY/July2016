package week1.day1.zoo;


public class Animal {

    String name;

    public void makeSound() {
        System.out.println("Animal Sound");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
