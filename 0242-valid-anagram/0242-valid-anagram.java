class Solution {
 static HashMap<Character,Integer>mapFreq(String str){
     HashMap<Character,Integer> map=new HashMap<>();
     for(int i=0;i<str.length();i++){
         char ch=str.charAt(i);
         if(!map.containsKey(ch)){
             map.put(ch, 1);
         }
         else{
             int currFre=map.get(ch);
             map.put(ch, currFre+1);
         }
     }
     return map;
 }
 
 public static boolean isAnagram(String s,String t){
     if(s.length()!=t.length()){
         return false;
     }
     HashMap<Character,Integer> map=mapFreq(s);
     for(int i=0;i<t.length();i++){
         char ch=t.charAt(i);
         if(!map.containsKey(ch)) return false;
         int currfreq=map.get(ch);
         map.put(ch, currfreq-1);
     }
     for(var i:map.values()){
         if(i!=0){
             return false;
         }
     }
     return true;
     
 }


}
