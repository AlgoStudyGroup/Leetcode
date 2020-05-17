class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){return head;}
        if(head.next==null){return head;}
        ListNode p = head;
        ListNode q = head.next;
        ListNode paire = head.next;
        ListNode cur = q.next;
        int i = 2;
        while(cur!=null){
            i++;
            if((i&1)==0){
                q.next = cur;
                q = q.next;
            }
            else{
                p.next = cur;
                p = p.next;
            }
            cur = cur.next;
        }
        q.next = null;
        p.next = paire;
        return head;// 1 2 4 5
    }
}

class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        // we separate the list to odd list and event list, and we combine these two list
        if(head == null)    return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
             
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;   
    }
}