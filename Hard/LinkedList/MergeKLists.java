package Hard.LinkedList;

import java.util.PriorityQueue;

public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            temp.next = minNode;
            temp = minNode;
            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
