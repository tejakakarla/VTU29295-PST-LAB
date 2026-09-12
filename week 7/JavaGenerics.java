/*
 * WEEK 7 - TASK 9
 * Problem: Java Generics
 * Platform: HackerRank
 *
 * Question:
 * Implement a generic printArray method that can print arrays containing
 * elements of different types. The method must work for both Integer and
 * String arrays without duplicating the method for each type.
 *
 * Solution:
 * Use a generic method <T> void printArray(T[] array) and iterate over the
 * elements, printing each one.
 */

public class JavaGenerics {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        printArray(intArray);
        printArray(stringArray);
    }
}
