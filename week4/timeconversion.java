class Result {

    public static String timeConversion(String s) {

        String period = s.substring(8, 10);
        int hour = Integer.parseInt(s.substring(0, 2));

        if (period.equals("PM")) {

            if (hour != 12) {
                hour += 12;
            }

        }
        else {

            if (hour == 12) {
                hour = 0;
            }
        }

        return String.format("%02d", hour) + s.substring(2, 8);
    }
}
