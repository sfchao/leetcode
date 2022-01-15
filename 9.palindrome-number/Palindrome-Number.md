# '9. Palindrome Number'
https://leetcode.com/problems/palindrome-number/

# Problem
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 
```
## Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
```
```
## Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

```
## Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
``` 

```
# Constraints:
-231 <= x <= 231 - 1
```

# Challenge: Could you solve it without converting the integer to a string?

class Solution {
    public boolean isPalindrome(int x) {
        // if x is negtive or is end with 0 
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        
        int processX = x;
        int reverseX = 0;
        while (processX > 0){
            reverseX = reverseX * 10 + processX%10;
            processX = processX/10;
        }
        
        return (x == reverseX);
        
    }
}



class Solution {
    public boolean isPalindrome(int x) {        
       if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }       
        int processX = x;
        int reverseX = 0;
        while (processX > reverseX){
            reverseX = reverseX * 10 + processX%10;
            processX = processX/10;
        }        
        return (processX == reverseX || processX == reverseX/10);
    }
}