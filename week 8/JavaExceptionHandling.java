/*
 * WEEK 8 - TASK 9
 * Problem: Java Exception Handling
 * Platform: HackerRank
 *
 * Question: Read a and b and calculate a^b. If a or b is negative, report
 * the appropriate exception message.
 */

import java.util.*;

class JavaExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        try {
            if (a < 0 || b < 0) {
                throw new Exception("n and p should be non-negative");
            }
            System.out.println((long) Math.pow(a, b));
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}
