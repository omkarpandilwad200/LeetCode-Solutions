class Solution {
    static HashMap<Character,Integer> mapFreq(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                int currfreq=map.get(ch);
                map.put(ch,currfreq+1);
            }
            
        }
        return map;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> mp1=mapFreq(s);
        HashMap<Character,Integer> mp2=mapFreq(t);

        return mp1.equals(mp2);


        
    }
}