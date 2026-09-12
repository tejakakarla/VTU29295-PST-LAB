/*
 * WEEK 7 - TASK 2
 * Problem: Java Instanceof Keyword
 * Platform: HackerRank
 *
 * Question:
 * Create objects of Student, Rockstar, and Hacker according to the input and
 * use instanceof to count how many objects belong to each class.
 *
 * Solution:
 * Store the objects as Object references. For every object, test it with
 * instanceof and increment the corresponding counter.
 */

import java.util.*;

class Student { }
class Rockstar { }
class Hacker { }

public class JavaInstanceofKeyword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("Student")) {
                list.add(new Student());
            } else if (type.equals("Rockstar")) {
                list.add(new Rockstar());
            } else if (type.equals("Hacker")) {
                list.add(new Hacker());
            }
        }

        int student = 0;
        int rockstar = 0;
        int hacker = 0;

        for (Object obj : list) {
            if (obj instanceof Student) {
                student++;
            }
            if (obj instanceof Rockstar) {
                rockstar++;
            }
            if (obj instanceof Hacker) {
                hacker++;
            }
        }

        System.out.println(student + " " + rockstar + " " + hacker);
        sc.close();
    }
}
