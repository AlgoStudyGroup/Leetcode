/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (head == NULL or head->next == NULL) return head;
        ListNode *p = head, *q = head->next;
        ListNode* head_even = head->next;
        ListNode* cur = q->next;
        int i = 2;
        while (cur){
            i ++;
            if (i & 1)  {
                p->next = cur;
                p = cur;
            }
            else {
                q->next = cur;    
                q = cur;
            }
            cur = cur->next;
        }
        q->next = NULL;
        p->next= head_even;
        return head;
    }
};