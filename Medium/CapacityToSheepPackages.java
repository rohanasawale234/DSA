package Medium;

import java.util.Arrays;
class Solution {
    private int findDays(int[] w, int cap){
        int days = 1, load = 0;
        for(int i = 0; i < w.length; i++){
            if(w[i] + load > cap){
                days += 1;
                load = w[i];
            }
            else{
                load += w[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maxCap = Arrays.stream(weights).max().getAsInt();
        int sum = Arrays.stream(weights).sum();
        int low = maxCap, high = sum;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int noOfDays = findDays(weights, mid);
            if(noOfDays <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Sample input
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Call the method and print the result
        int result = solution.shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship within " + days + " days is: " + result);
    }
}