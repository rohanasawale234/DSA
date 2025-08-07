package Medium.Arrays;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int n : nums){
            pq.offer(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
