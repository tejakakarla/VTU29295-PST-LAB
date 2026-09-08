class Solution {

    public boolean rotateString(
            String s,
            String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        String text = s + s;

        return kmpSearch(text, goal);
    }

    private boolean kmpSearch(
            String text,
            String pattern) {

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

                if (j == pattern.length()) {
                    return true;
                }

            } else {

                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private int[] buildLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) ==
                pattern.charAt(len)) {

                lps[i] = ++len;
                i++;

            } else if (len > 0) {

                len = lps[len - 1];

            } else {

                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}
