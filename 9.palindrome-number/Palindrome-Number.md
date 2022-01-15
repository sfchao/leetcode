# '9. Palindrome Number'
https://leetcode.com/problems/palindrome-number/

## Problem
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

## Challenge: 
###Could you solve it without converting the integer to a string?

###Key : find each digit using mathematic method. 
You can use mod method to find the remain in Java. like this

```
19 % 10 => 9
```

And use divid to move down the digits 

```
189 / 10 = 18 
```
3rd key is to add each found digit to a variable in reverse sequence. 

```
reverseX = 0 
x = 189
digit = 189 % 10 = 9
reverseX = reverseX *10 + digit => 0 *10 + 9 = 9
x = 189/10 = 18

loop through each digits;
```

Here is the implementation in Java
```
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
```

## optimization: 
In fact , there is no need to looping through all digits. Only need to loop through half of digits. 
```
Example: 
input: 18781

loop each digits of 18781

1 run :
   x = 18781
   digit = 18781 % 10 = 1
   reverseX = 0*10 + 1 = 1
   x = 18781 / 10 = 1878

2 run :
   x = 1878
   digit = 1878 % 10 = 8
   reverseX = 1*10 + 8 = 18
   x = 1878 / 10 = 187

3 run :
    x = 187
   digit = 187 % 10 = 7
   reverseX = 18*10 + 7 = 187
   x = 187 / 10 = 18

since x < revserX, it already loop half of the digits
now we can compare x and revserX. 
There will be 2 scenarios
 x = reverseX or x = reverseX/10

```


```
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
```