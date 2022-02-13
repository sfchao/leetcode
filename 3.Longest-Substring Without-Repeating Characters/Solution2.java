class Solution {
    public int lengthOfLongestSubstring(String s) {
        int tempLen = 0;
        int result = 0;
        int dupIndex = 0;
        HashMap<String, Integer> subMap = new HashMap<>();
        int lp = 0;
        
        if(s.isEmpty())
            return 0;
        
        if (s.length() ==1)
             return 1;
    
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