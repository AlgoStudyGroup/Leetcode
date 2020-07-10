class Solution1 {
public:
    Node* flatten(Node* head, Node* tail = nullptr) {
        if(!head) return nullptr;
        Node* read = head, *pre;
        while(read){
            if(read->child){
                Node* tmp = read->next;
                Node* connect = flatten(read->child, tmp);
                read->child = nullptr;
                read->next = connect;
                read->next->prev = read;                
            }
            pre = read;
            read = read->next;
        }
        if(tail)
            pre->next = tail, tail->prev = pre; 
        return head;
    }
};
