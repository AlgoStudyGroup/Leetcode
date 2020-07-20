class Solution1 {
public:
    ListNode* removeElements(ListNode* head, int val) {
        
        head = new ListNode(-1,head);
        ListNode* prev = head, *curr = head->next;
        
        while(curr){
            if(curr->val == val)
                prev->next = prev->next->next;
            else
                prev = curr;
            curr = curr->next;
        }
        
        return head->next;
    }
};
