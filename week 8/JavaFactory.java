/*
 * WEEK 8 - TASK 8
 * Problem: Java Factory Pattern
 * Platform: HackerRank
 *
 * Question: Use a factory class to create a Pizza or Cake object based on
 * the supplied food type, then print the selected food and its preparation.
 */

import java.util.*;

interface Food {
    String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) return new Pizza();
        if (order.equalsIgnoreCase("cake")) return new Cake();
        return null;
    }
}

class JavaFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = sc.nextLine();
        FoodFactory factory = new FoodFactory();
        Food food = factory.getFood(order);
        if (food != null) {
            System.out.println("The factory returned " + food.getClass().getSimpleName());
            System.out.println(food.getType());
        }
        sc.close();
    }
}
