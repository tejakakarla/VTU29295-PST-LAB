class NaivePatternSearch {

    static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {

            int j;

            // Compare pattern with text
            for (j = 0; j < m; j++) {

                if (text.charAt(i + j)
                        != pattern.charAt(j)) {

                    break;
                }
            }

            // Pattern completely matched
            if (j == m) {
                System.out.println(
                    "Pattern found at index " + i
                );
            }
        }
    }

    public static void main(String[] args) {

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        search(text, pattern);
    }
}
