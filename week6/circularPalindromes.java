import java.util.*;

class Result {

    public static List<Integer> circularPalindromes(
            String s,
            List<Integer> queries) {

        int n = s.length();

        List<Integer> result = new ArrayList<>();

        /*
         * Create doubled string.
         * This represents all circular continuations.
         */
        String doubled = s + s;

        /*
         * For each query, interpret the query
         * as a starting position and find the
         * longest palindrome in the circular
         * string.
         */
        for (int start : queries) {

            int best = longestPalindromeFrom(
                doubled,
                start,
                start + n
            );

            result.add(best);
        }

        return result;
    }

    private static int longestPalindromeFrom(
            String s,
            int start,
            int end) {

        int best = 1;

        for (int center = start;
             center < end;
             center++) {

            // Odd-length palindrome
            int left = center;
            int right = center;

            while (left >= start &&
                   right < end &&
                   s.charAt(left) ==
                   s.charAt(right)) {

                best = Math.max(
                    best,
                    right - left + 1
                );

                left--;
                right++;
            }

            // Even-length palindrome
            left = center;
            right = center + 1;

            while (left >= start &&
                   right < end &&
                   s.charAt(left) ==
                   s.charAt(right)) {

                best = Math.max(
                    best,
                    right - left + 1
                );

                left--;
                right++;
            }
        }

        return best;
    }
}
