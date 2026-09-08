BRUTE:
class Result {

    public static int birthday(
            List<Integer> s,
            int d,
            int m) {

        int count = 0;

        for (int i = 0; i <= s.size() - m; i++) {

            int sum = 0;

            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            if (sum == d) {
                count++;
            }
        }

        return count;
    }
}



OPTIMIZED:
class Result {

    public static int birthday(
            List<Integer> s,
            int d,
            int m) {

        int count = 0;
        int sum = 0;

        // First window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        // Slide window
        for (int i = m; i < s.size(); i++) {

            sum += s.get(i);
            sum -= s.get(i - m);

            if (sum == d) {
                count++;
            }
        }

        return count;
    }
}
