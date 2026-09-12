/*
 * WEEK 8 - TASK 7
 * Problem: Java HashSet
 * Platform: HackerRank
 *
 * Question: For each pair of strings, add the pair to a HashSet and print
 * the number of distinct pairs seen so far.
 */

import java.util.*;

class JavaHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Set<String> pairs = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String first = sc.next();
            String second = sc.next();
            pairs.add(first + " " + second);
            System.out.println(pairs.size());
        }
        sc.close();
    }
}
