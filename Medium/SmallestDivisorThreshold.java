package Medium;

import java.util.Arrays;
class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;

            for (int num : nums) {
                sum += (int) Math.ceil((double) num / mid);
            }

            if (sum > threshold) {
                left = mid + 1; 
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        int res = smallestDivisor(nums, threshold);
    }
}
