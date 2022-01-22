/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode pre = null, firstNode = null, secondNode = null, thirdNode = null;
        // get the first 3 node
        firstNode = head;
        secondNode = firstNode.next;
        thirdNode = secondNode.next;
        head = secondNode;        
        while (firstNode != null && secondNode != null){
            // swap             
            secondNode.next = firstNode;
            firstNode.next = thirdNode;
            if (pre != null)
                pre.next = secondNode;
            // move each node to next 4 items            
            pre = firstNode;  // the next pre node is the 2nd position which is the firstNode
            firstNode = thirdNode;  //move the first node to the 3nd node
            if (firstNode != null)
                secondNode = firstNode.next; // get the second node 
            if (secondNode != null)
                thirdNode = secondNode.next; // get the third node
        }
        
        return head;
    }
    
    
}