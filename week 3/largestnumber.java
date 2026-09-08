import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to Strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator
        Arrays.sort(arr, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;

            return order2.compareTo(order1);
        });

        // If the largest number is "0", return "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the answer
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}
