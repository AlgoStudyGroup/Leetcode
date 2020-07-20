# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        prev = ListNode(-1, head)
        h = prev
        cur = head
        while(cur):
            while (cur and cur.val == val):
                cur = cur.next
            prev.next = cur
            prev = cur
            if (cur):
                cur = cur.next
        return h.next