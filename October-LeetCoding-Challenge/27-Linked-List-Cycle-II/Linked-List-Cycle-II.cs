namespace _142_Linked_List_Cycle_II
{
    public class Solution
    {
        public ListNode DetectCycle(ListNode head)
        {
            var fast = head;
            var slow = head;
            while (fast != null && fast.next != null)
            {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow)
                {
                    var slow2 = head;
                    while (slow != slow2)
                    {
                        slow = slow.next;
                        slow2 = slow2.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }

    /* Definition for singly-linked list.*/
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x)
        {
            val = x;
            next = null;
        }
    }
}