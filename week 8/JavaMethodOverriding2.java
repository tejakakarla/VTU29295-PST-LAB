/*
 * WEEK 8 - TASK 2
 * Problem: Java Method Overriding 2 (Super Keyword)
 * Platform: HackerRank
 *
 * Question: Demonstrate method overriding and use super to invoke the
 * superclass implementation before printing the subclass-specific output.
 */

class BiCycle {
    String define_me() {
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle {
    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        String temp = super.define_me();
        System.out.println("My ancestor is a cycle who is " + temp);
    }
}

class JavaMethodOverriding2 {
    public static void main(String[] args) {
        new MotorCycle();
    }
}
