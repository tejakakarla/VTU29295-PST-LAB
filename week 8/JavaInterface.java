/*
 * WEEK 8 - TASK 6
 * Problem: Java Interface
 * Platform: HackerRank
 *
 * Question: Implement the AdvancedArithmetic interface and calculate the
 * sum of all divisors of a given positive integer.
 */

import java.util.*;

interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) sum += n / i;
            }
        }
        return sum;
    }
}

class JavaInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdvancedArithmetic calculator = new MyCalculator();
        System.out.println("I implemented: AdvancedArithmetic");
        System.out.println(calculator.divisor_sum(n));
        sc.close();
    }
}
