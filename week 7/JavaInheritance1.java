/*
 * WEEK 7 - TASK 7
 * Problem: Java Inheritance I
 * Platform: HackerRank
 *
 * Question:
 * Demonstrate inheritance by creating a Bird class with fly() and a subclass
 * that inherits the method and adds its own functionality.
 *
 * Solution:
 * Create Animal/Bird-style inheritance and invoke the inherited method from
 * the subclass object.
 */

class Animal {
    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("I am flying");
    }
}

public class JavaInheritance1 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
    }
}
