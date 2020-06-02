/*
 * @description:  
 * @author: ZHU Fangda
 * @Date: 2020-06-02 10:15:17
 * @LastEditors: ZHU Fangda
 * @LastEditTime: 2020-06-02 10:16:08
 */ 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void deleteNode(ListNode node) {
      
      node.val = node.next.val;
      node.next = node.next.next;
      
  }
}