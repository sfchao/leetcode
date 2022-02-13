import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class PSolution{
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("s.length: " 
                           + s.length());
        

        boolean foundDup = false;
        HashMap<String, Integer> subMap = new HashMap<>();
        int max = 0, winmax = 0;
        int end = 0;
        int result = 0;
        while(end < s.length()) {
            String ch = s.substring(end, end+1);
            subMap.put(ch, subMap.getOrDefault(ch,0) + 1); 
            
            System.out.println("Modified HashMap: "+ subMap); 
            
            
            winmax = Math.max(subMap.size(),winmax);
            foundDup = false;
            for(Map.Entry entry : subMap.entrySet()) {
                String key = (String)entry.getKey();
                int value = ((int)entry.getValue());
                System.out.println(key + " : " + value);
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
           
          System.out.println(">>>>>>>>>>>>>>>>" +  end);      
        }
         result = Math.max(max, winmax);

        /////////////// method 2 ////////////////
        // int lp = 0;
        // int tempLen = 0;
        // int result = 0;
        // int dupIndex = 0;
        // HashMap<String, Integer> subMap = new HashMap<>();
        // for (int rp = 0; rp < s.length(); rp ++){
        //     String ch = s.substring(rp, rp+1);
               
        //        System.out.println("result: "+ result);
        //     if (subMap.containsKey(ch)){ 
        //         // found the duplicate, calculate the length
        //         tempLen = (rp - 1) - lp +1;
        //         result = Math.max(tempLen,result);

        //         System.out.println("tempLen: "+ tempLen);                
                
        //         // get the position of previous dup char
        //         dupIndex = subMap.get(ch);
        //         System.out.println("dupIndex :" + dupIndex);
        //         for(Map.Entry entry : subMap.entrySet()) {
        //             String key = (String)entry.getKey();
        //             int value = ((int)entry.getValue());
        //             System.out.println(key + " : " + value);
        //             if (value <= dupIndex)

        //         }
        //         // // remove all the char in the hashMap which index was less than dupIndex
        //         // Iterator<Map.Entry<String, Integer> > iterator = subMap.entrySet().iterator();

        //         // while (iterator.hasNext()) {  
        //         //     // Get the entry at this iteration
        //         //     Map.Entry<String, Integer>
        //         //         entry
        //         //         = iterator.next();
        
        //         //     // Check if this value is the required value
        //         //     if (entry.getValue() <= dupIndex) {
        
        //         //         // Remove this entry from HashMap
        //         //         iterator.remove();
        //         //     }
        //         // }

        //         // update lp
        //         lp = dupIndex+ 1 ;              
        //         System.out.println("Modified HashMap: "
        //                    + subMap);
                
        //     }
        //     subMap.put(ch, rp);  
        //     result = Math.max(subMap.size(),result);
        //     System.out.println("Modified HashMap: "
        //                    + subMap);
        //     System.out.println(">>>>>>>>>>>>>>>>");
        // }

        System.out.println("result : "+ result);
    
    //    return result;
        // Create a HashMap
        // HashMap<String, Integer> subMap = new HashMap<>();
        // subMap.put("a", 3);
        // subMap.put("b", 4);
        // subMap.put("c", 5);
        // subMap.put("b", 6);
  
        // // Get the value to be removed
        // Integer valueToBeRemoved = 4;
  
        // // Print the initial HashMap
        // System.out.println("Original HashMap: "
        //                    + subMap);

        // subMap.entrySet()
        //     .removeIf(
        //         entry -> (entry.getValue() <= valueToBeRemoved));
  
        // // Get the iterator over the HashMap
        // Iterator<Map.Entry<String, Integer> >
        //     iterator = subMap.entrySet().iterator();
  
        // // Iterate over the HashMap
        // while (iterator.hasNext()) {
  
        //     // Get the entry at this iteration
        //     Map.Entry<String, Integer>
        //         entry
        //         = iterator.next();
  
        //     // Check if this value is the required value
        //     if (valueToBeRemoved.equals(entry.getValue())) {
  
        //         // Remove this entry from HashMap
        //         iterator.remove();
        //     }
        // }
  
        // Print the modified HashMap
        // System.out.println("Modified HashMap: "
        //                    + subMap);
        
    
    
    }

    
}