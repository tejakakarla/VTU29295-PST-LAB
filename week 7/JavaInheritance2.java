/*
 * WEEK 7 - TASK 8
 * Problem: Java Inheritance II
 * Platform: HackerRank
 *
 * Question:
 * Create a class Arithmetic with an add method. Create a class Adder that
 * inherits Arithmetic. The program should demonstrate inheritance and print
 * the superclass name and the result of adding 42 and 13.
 *
 * Solution:
 * Adder extends Arithmetic, so an Adder object can directly call the inherited
 * add() method.
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
    }
}
