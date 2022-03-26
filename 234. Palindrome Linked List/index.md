# 234. Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/

## Problem

Given the head of a singly linked list, return true if it is a palindrome.


### Example 1:

![Screenshot](pal1linked-list.jpeg)
```
Input: head = [1,2,2,1]
Output: true
```
### Example 2:
![Screenshot](pal2linked-list.jpeg)

```
Input: head = [1,2]
Output: false
```


### Constraints:
* The number of nodes in the list is in the range [1, 105].
* 0 <= Node.val <= 9

## Approach 1: Copy into Array List and then Use Two Pointer Technique1
- Convert linked list to array list
- Compare node from forward and backward

**Runtime: 16 ms**

**Memory: 108.1 MB**
 
```
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
```

## Approach 2: Using StringBuffer - Use Java StringBuffer to compare the forward string and backward string. 
- Conver the head to StringBuffer
- User StringBuffer.reverse to get the reverse String
- Compare 2 String

**Runtime: 50 ms**

**Memory: 104.7 MB**

```
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        Lclass Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder s = new StringBuilder("");
        s =  getLastNode(head,s); //get last element
       StringBuilder sF = new StringBuilder(s).reverse();
       if(s.toString().equals(sF.toString())) return true;
       else return false;
    }
        public static StringBuilder getLastNode(ListNode tale, StringBuilder s) {
        if (tale == null) return s;
        s.append(tale.val);
        return getLastNode(tale.next, s);
    }
}
```

## Approach 3: Reverse Second Half In-place

- Find the end of the first half / middle element.
- Reverse the second half.
- Compare 2 linked list nodes to see if there is a palindrome

**Runtime: 5 ms**

**Memory: 97.3 MB**

```
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
		//using slow and fast pointers find the middle element.
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
		// From slow pointer onwards reverse the linked list.
        ListNode prev = null;
        ListNode next = slow;
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
		//Now start comparing values from both sides and return false, if values are not equal.
        while(prev!=null){
            if(head.val!=prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
```

## Approach 4: Recursive

This is still _O(n)_space, not O(1)

**Runtime: 24 ms**

**Memory: 103.9 MB**

```
class Solution {

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
```

## Performance 

| Approach     | Runtime | Memory   |   Method      |
| :---         | :----:  |   :---:  |   :---:       |
| Approach 1   | 16 ms   | 108.1 MB | ArrayList     |
| Approach 2   | 50 ms   | 104.7 MB | StringBuffer  |
| Approach 3   | 5  ms   | 97.3  MB | 2 Pointers    |
| Approach 4   | 24 ms   | 103.9 MB | Recursive     |




