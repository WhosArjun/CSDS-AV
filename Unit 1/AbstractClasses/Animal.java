package AbstractClasses;

public abstract class Animal {
    String name;
    int age;
    double weight;

    public abstract void makeSound();

    //You are allowed to create concrete methods to be implemented in your code
    public void introduce(){
        System.out.println("My name is " + name);
    }
}
