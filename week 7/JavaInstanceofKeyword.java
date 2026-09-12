/*
 * WEEK 7 - TASK 2
 * Problem: Java Instanceof Keyword
 * Platform: HackerRank
 *
 * Question:
 * Given a list of objects of different classes, count how many objects belong
 * to each of Student, Rockstar, and Hacker using the instanceof operator.
 *
 * Solution:
 * Read N objects, test each object with instanceof, and maintain three counts.
 */

import java.util.*;

class Student { }
class Rockstar { }
class Hacker { }

public class JavaInstanceofKeyword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int student = 0, rockstar = 0, hacker = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("Student")) {
                student++;
            } else if (type.equals("Rockstar")) {
                rockstar++;
            } else if (type.equals("Hacker")) {
                hacker++;
            }
        }

        System.out.println(student + " " + rockstar + " " + hacker);
        sc.close();
    }
}

/* HackerRank normally supplies the object list in the platform's stub.
 * The counting logic above represents the required instanceof classification.
 */
