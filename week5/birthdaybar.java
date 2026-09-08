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
