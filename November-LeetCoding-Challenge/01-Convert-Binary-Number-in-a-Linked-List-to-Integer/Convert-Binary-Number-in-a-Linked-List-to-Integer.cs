namespace _1290_Convert_Binary_Number_in_a_Linked_List_to_Integer
{
    public class Solution
    {
        public int GetDecimalValue(ListNode head)
        {
            //Solution 1
            var res = 0;
            while (head != null)
            {
                res = res * 2 + head.val;
                head = head.next;
            }
            return res;

            //Solution 2: Stack, from end to beginning
            /*
            var stack = new Stack<int>();
            while(head != null){
                stack.Push(head.val);
                head = head.next;
            }

            var res = 0;
            var lvl = 1;
            res += stack.Pop();

            while(stack.Count > 0){
                lvl *= 2;
                res += lvl * stack.Pop();
            }

            return res;
            */
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