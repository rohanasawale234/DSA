import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(diff)){
                return new int [] {map.get(diff), i};
            }

            map.put(nums[i], i);
        }
        return new int [0];
    }

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 9;
    }
}

