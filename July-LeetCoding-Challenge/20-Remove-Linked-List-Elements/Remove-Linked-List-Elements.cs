public class Solution {
    public ListNode RemoveElements(ListNode head, int val) {
        if(head == null) return null;
        var curr = new ListNode(-1);
        curr.next = head;
        head = curr;
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */