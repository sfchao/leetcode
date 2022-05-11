import java.util.HashMap;
import java.util.Map;
public class Solution{
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(s);
        // System.out.println(s.substring(0,1));
        int answer =  new Solution().lengthOfLongestSubstring(s);
        System.out.println(answer);
    }
    public int lengthOfLongestSubstring(String s) {
        int lng = s.length();
        boolean isUniqe = true;
        int result = 0;
        int tempLen = 0;
        Map<String, Integer> subMap = new HashMap<>();
        for(int startI = 0; startI < lng ; startI++){
           
            for(int endI=startI+1; endI <= lng; endI++) {
                String sub = s.substring(startI,endI);      
                System.out.println("startI: " +  startI); 
                System.out.println("endI: " +  endI);            
                System.out.println(sub);   
                 // verify if the substring is uniqe
                isUniqe = true;
                System.out.println("verify if the substring is uniqe");
                subMap = new HashMap<>();
                for(int i= 0; i <= sub.length() -1 ; i++){
                    String c =  sub.substring(i,i+1);
                    System.out.println("c is >>" + c);
                    if (subMap.containsKey(c)){
                         System.out.println("there is dup");
                        isUniqe = false;    
                        break;
                    }else{
                        subMap.put(c, i);        
                    }
                
                }
                System.out.println("isUniqe" + isUniqe);
                if (isUniqe){
                    tempLen = endI - startI;
                    if (tempLen > result){
                        result = tempLen;
                    }
                        
                }
                 System.out.println("result" + result);
                 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");    
            }
        }
        
       return result;
    }
}