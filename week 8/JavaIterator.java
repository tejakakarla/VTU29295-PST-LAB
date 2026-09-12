/*
 * WEEK 8 - TASK 5
 * Problem: Java Iterator
 * Platform: HackerRank
 *
 * Question: Use Java's Iterator to traverse a collection and print only the
 * string elements that occur after the integer elements in the supplied list.
 */

import java.util.*;

class JavaIterator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String value = scan.next();
            try {
                list.add(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                list.add(value);
            }
        }

        Iterator<Object> iterator = list.iterator();
        boolean print = false;
        while (iterator.hasNext()) {
            Object value = iterator.next();
            if (value instanceof String) {
                print = true;
            }
            if (print && value instanceof String) {
                System.out.println(value);
            }
        }
        scan.close();
    }
}
