using System.Collections.Generic;

namespace _445_Add_Two_Numbers_II
{
    public class Solution
    {
        public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            Stack<int> s1 = new Stack<int>(), s2 = new Stack<int>();
            while (l1 != null)
            {
                s1.Push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null)
            {
                s2.Push(l2.val);
                l2 = l2.next;
            }

            var sum = 0;
            var node = new ListNode(0);
            while (s1.Count > 0 || s2.Count > 0)
            {
                if (s1.Count > 0) sum += s1.Pop();
                if (s2.Count > 0) sum += s2.Pop();
                node.val = sum % 10;

                var head = new ListNode(sum / 10);
                head.next = node;
                node = head;

                sum /= 10;
            }

            return node.val == 0 ? node.next : node;
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