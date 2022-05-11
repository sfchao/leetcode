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
        ListNode h = head;
        int count = 0;
        HashMap hashm = new HashMap();
        // loop through the ListNode to collect the val and find total count
        while (h != null){
            count++;   
            hashm.put(count, h.val);
            h = h.next;     
        }
        int nk = count - k + 1;    // calculate the backward poistion
        ListNode newHead = null ,last = null, temp = null;
        
        // loop through the HashMap to create the new ListNode
        for (int i = 1; i<= count; i++){
            if (i == k){
                    temp = new ListNode((int)hashm.get(nk));    // the the backword element
                }else if(i == nk){
                    temp = new ListNode((int)hashm.get(k));     // the k element
                }else{
                    temp = new ListNode((int)hashm.get(i));     // regular element
                }
            // adding the ListNode to new head
            if (newHead == null){        
                last =  temp;
                newHead = last;
            }else{
                last.next = temp;                
                last = last.next;
            }
        }        
        return newHead;
        
    }
}