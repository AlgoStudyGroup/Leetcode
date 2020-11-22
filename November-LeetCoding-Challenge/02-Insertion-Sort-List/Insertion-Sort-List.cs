namespace _147_Insertion_Sort_List
{
    public class Solution
    {
        public ListNode InsertionSortList(ListNode head)
        {
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            while (head != null)
            {
                ListNode temp = head.next;

                /* Before insert, the prev is at the last node of the sorted list.
                   Only the last node's value is larger than the current inserting node 
                   should we move the temp back to the head*/
                if (prev.val >= head.val) prev = dummy;

                while (prev.next != null && prev.next.val < head.val)
                {
                    prev = prev.next;
                }

                head.next = prev.next;
                prev.next = head;
                // prev = dummy; // Don't set prev to the head of the list after insert
                head = temp;
            }
            return dummy.next;
        }
    }
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int val = 0, ListNode next = null)
        {
            this.val = val;
            this.next = next;
        }
    }
}