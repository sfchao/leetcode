# 3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/

## Problem

Given a string s, find the length of the **longest substring** without repeating characters.


**Example 1:**
```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```
**Example 2:**
```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
**Example 3:**
```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
**Example 4:**
```
Input: s = " "
Output: 1
```

**Example 5:**
```
Input: s = ""
Output: 0
```

### Constraints::
* 0 <= s.length <= 5 * 104
* s consists of English letters, digits, symbols and spaces.

## First thought. 
Two loops througth the array, compare the char, compare the char with another char in the HashMap, if there is no matched, add to the HashMap. 
The complexity is O(n^3), not over the time limit. 

## Sliding Window Algorithm
The main idea behind the sliding window technique is to convert two nested loops into a single loop. Usually, the technique helps us to reduce the time complexity from O(n^2) to O(n).

Use right and left pointer, the right pointer hold the postion of the starting of the none-repeated-substring. Move the left pointer to each chararter. Use a HashSet or HashMap to store the character and the index position. Loop througth each character, if the character is found in the HashMap, calcuate the length, and move up the start pointer to the last character position +1. 

https://www.baeldung.com/cs/sliding-window-algorithm

## The Optimized Solution
I had referenced to one of the explanation of using sliding window algorithm, but in that article it mention keep tracking and remove the elements which index was before new identical character. In fact, there is no need to keep tracking of or previous character since it just asking for the length of the substring not the actual substring. Therefore only need to calculate the length each time there is a match on the character. 

## Explaniation

[a,b,c,a,b,c,b,b]

[0,1,2,3,4,5,6,7]

Variables: right =0, left =0, hashmap ={}

left = 0  =======> ch = a, haspmap = {a:0},  length = left - right +1 = 0-0+1 = 1

left = 1  =======> ch = b, haspmap = {a:0, b:1}, length = left - right +1 = 1-0+1 = 2

left = 2  =======> ch = c, haspmap = {a:0, b:1, c:2}, length = left - right +1 = 2-0+1 = 3

left = 3  =======> ch = a, Match found => <mark>update start pointer to index of a + 1(0+1=1)</mark>, haspmap = {a:3, b:1, c:2},  length = left - right +1 = 3-1+1 = 3

left = 4  =======> ch = b, Match found => <mark>update start pointer to index of b + 1(1+1=2)</mark>, haspmap = {a:3, b:4, c:2},  length = left - right +1 = 4-2+1 = 3

left = 5  =======> ch = c, Match found => <mark>update start pointer to index of c + 1(2+1=3)</mark>, haspmap = {a:3, b:4, c:5},  length = left - right +1 = 5-3+1 = 3

left = 6  =======> ch = b, Match found => <mark>update start pointer to index of b + 1(4+1=5)</mark>, haspmap = {a:3, b:6, c:5},  length = left - right +1 = 6-5+1 = 2

left = 7  =======> ch = b, Match found => <mark>update start pointer to index of b + 1(6+1=7)</mark>, haspmap = {a:3, b:7, c:6},  length = left - right +1 = 7-7+1 = 1

###  Optimized implementation

```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> note = new HashMap<Character, Integer>();
        int length = 0;
        
        for (int start = 0, end = 0; end < s.length(); end ++) {
            if (note.containsKey(s.charAt(end))) {
                start = Math.max(start, note.get(s.charAt(end))+1);
            }
            
            note.put(s.charAt(end), end);
            length = Math.max(length, end-start+1);
        }
        
        return length;
    }
}
```

### My Sliding Window implementation [Failed]
 ```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int tempLen = 0;
        int result = 0;
        int dupIndex = 0;
        HashMap<String, Integer> subMap = new HashMap<>();
        int lp = 0;
            
        for (int rp = 0; rp < s.length(); rp ++){
           String ch = s.substring(rp, rp+1);
             
            if (subMap.containsKey(ch)){ 
                // found the duplicate, calculate the length
                tempLen = (rp - 1) - lp +1;
                result = Math.max(tempLen,result);
                
                // get the position of previous dup char
                dupIndex = subMap.get(ch);

                // // remove all the char in the hashMap which index was less than dupIndex
                Iterator<Map.Entry<String, Integer> > iterator = subMap.entrySet().iterator();

                while (iterator.hasNext()) {  
                    // Get the entry at this iteration
                    Map.Entry<String, Integer>
                        entry
                        = iterator.next();
        
                    // Check if this value is the required value
                    if (entry.getValue() <= dupIndex) {
        
                        // Remove this entry from HashMap
                        iterator.remove();
                    }
                }

                // update lp
               lp = dupIndex+ 1 ;       

                
            }
                subMap.put(ch, rp);  
                result = Math.max(subMap.size(),result);
        }         
       return result;
    }
}
```

### Enhanced implementation [Pass, but slow]
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean foundDup = false;
        HashMap<String, Integer> subMap = new HashMap<>();
        int max = 0, winmax = 0;
        int end = 0;
       
        while(end < s.length()) {
            String ch = s.substring(end, end+1);
            subMap.put(ch, subMap.getOrDefault(ch,0) + 1); 
 
            winmax = Math.max(subMap.size(),winmax);
            foundDup = false;
            for(Map.Entry entry : subMap.entrySet()) {
                String key = (String)entry.getKey();
                int value = ((int)entry.getValue());
                // System.out.println(key + " : " + value);
                if (value > 1)
                    foundDup = true;
            }

            if (foundDup){
                subMap.clear();
                // subMap.put(ch, subMap.getOrDefault(ch,0) + 1); 
                end = end - winmax + 1;
                max = Math.max(max,winmax);
                winmax = 0;               
            }else{
                 end++;
            }
           
          // System.out.println(">>>>>>>>>>>>>>>>" +  end);      
        }
       return Math.max(max, winmax);
    }
}
```

