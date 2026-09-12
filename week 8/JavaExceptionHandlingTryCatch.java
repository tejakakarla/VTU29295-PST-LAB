/*
 * WEEK 8 - TASK 10
 * Problem: Java Exception Handling (Try-Catch)
 * Platform: HackerRank
 *
 * Question: Perform integer division for each input pair. Catch division by
 * zero and invalid input exceptions and print the required error message.
 */

import java.util.*;

class JavaExceptionHandlingTryCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            try {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println("java.lang.ArithmeticException: / by zero");
            } catch (InputMismatchException e) {
                System.out.println("java.util.InputMismatchException");
                if (sc.hasNext()) sc.next();
            }
        }
        sc.close();
    }
}
