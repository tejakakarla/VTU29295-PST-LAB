/*
 * WEEK 7 - TASK 6
 * Problem: Grading Students
 * Platform: HackerRank
 *
 * Question:
 * Round each student's grade according to these rules: grades below 38 are
 * not rounded. Otherwise, find the next multiple of 5. If the difference is
 * less than 3, round up; otherwise leave the grade unchanged.
 *
 * Solution:
 * Compute the next multiple of 5 and compare its difference with the grade.
 */

import java.util.*;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {
            if (grade < 38) {
                result.add(grade);
                continue;
            }

            int nextMultiple = ((grade / 5) + 1) * 5;
            if (nextMultiple - grade < 3) {
                result.add(nextMultiple);
            } else {
                result.add(grade);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        for (int grade : gradingStudents(grades)) {
            System.out.println(grade);
        }
        sc.close();
    }
}
