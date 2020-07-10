public class Solution {
    public Node Flatten(Node head) {
        if(head == null) return null;
        var stack = new Stack<Node>();
        var c = head;
        
        while(c != null){
            if(c.child != null){
                if(c.next != null){
                    stack.Push(c.next);
                }
                c.next = c.child;
                c.next.prev = c;
                c.child = null;
            }else if(c.next == null && stack.Count > 0){
                c.next = stack.Pop();
                c.next.prev = c;
            }
            
            c = c.next;
        }
        
        return head;        
    }
}

/*
// Definition for a Node.
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
*/