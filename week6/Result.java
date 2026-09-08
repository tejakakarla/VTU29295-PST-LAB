class Result {

    public static String twoStrings(
            String s1,
            String s2) {

        boolean[] present = new boolean[256];

        for (char c : s1.toCharArray()) {
            present[c] = true;
        }

        for (char c : s2.toCharArray()) {

            if (present[c]) {
                return "YES";
            }
        }

        return "NO";
    }
}
