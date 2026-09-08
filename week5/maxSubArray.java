BRUTE:
class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}

OPTIMIZED:
class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(
                nums[i],
                currentSum + nums[i]
            );

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
