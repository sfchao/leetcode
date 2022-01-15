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