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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode kNode = head;
        ListNode bkNode = head;
        // [1,2,3,4,5]
        for(int i=0;i<k-1;i++)
        {
            fast = fast.next;        // fast = 2
        }   
        // Save the node for swapping
        kNode = fast;            // kNode = 2
        // Move until the end of the list
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        // Save the node for swapping
        bkNode = slow ;            // bkNode = 4

        // Swap first and second                
        int temp = kNode.val;
        kNode.val = bkNode.val;
        bkNode.val = temp;

        return head;
    }
}