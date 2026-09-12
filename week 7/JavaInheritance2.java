/*
 * WEEK 7 - TASK 8
 * Problem: Java Inheritance II
 * Platform: HackerRank
 *
 * Question:
 * Create a class Arithmetic with a method add(int a, int b), and a class Adder
 * that inherits Arithmetic. Demonstrate that Adder can use the inherited method.
 *
 * Solution:
 * Extend Arithmetic and use the inherited add method through an Adder object.
 */

class Arithmetic {
    int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
}

public class JavaInheritance2 {
    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());
        System.out.println(adder.add(42, 13));
        System.out.println(adder.add(10, 20));
    }
}
