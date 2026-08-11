import java.util.*;

public class Solution {

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(year, month - 1, day);

        return calendar.getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.LONG,
            Locale.ENGLISH
        ).toUpperCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();
        int year = sc.nextInt();

        System.out.println(findDay(month, day, year));

        sc.close();
    }
}
