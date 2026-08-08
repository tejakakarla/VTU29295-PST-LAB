import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        if (s1.getCgpa() != s2.getCgpa()) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        }
        int nameCompare = s1.getFname().compareTo(s2.getFname());

        if (nameCompare != 0) {
            return nameCompare;
        }

        return Integer.compare(s1.getId(), s2.getId());
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String fname = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, fname, cgpa));
        }

        Collections.sort(students, new Checker());

        for (Student student : students) {
            System.out.println(student.getFname());
        }

        sc.close();
    }
}
