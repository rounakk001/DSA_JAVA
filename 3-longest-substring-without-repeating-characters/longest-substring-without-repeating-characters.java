class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),-1);
        }
        
        int n=s.length();
        int l=0,r=0,maxlen=0;

        while(r<n){
            if(map.get(s.charAt(r))!=-1){      //word is already in map
                if(map.get(s.charAt(r))>=l){     //looking for duplicates
                       l=map.get(s.charAt(r))+1;   //window ko aage laa rahe
                }
            }
           
           maxlen=Math.max(maxlen,r-l+1);
           map.put(s.charAt(r),r);
           r++;
        }
        return maxlen;
    }
}