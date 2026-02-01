class Solution {
    public int characterReplacement(String s, int k) {
              int n=s.length();
             int l=0,r=0,maxf=0,maxlen=0;

             HashMap<Integer,Integer> map=new HashMap<>();
             
             while(r<n){
                map.put(s.charAt(r)-'A',map.getOrDefault(s.charAt(r)-'A',0)+1);
                  maxf=Math.max(maxf,map.get(s.charAt(r)-'A'));
                 
                 if((r-l+1)-maxf>k){
                     map.put(s.charAt(l)-'A',map.get(s.charAt(l)-'A')-1);
                     l++;
                 }
                 maxlen=Math.max(maxlen,r-l+1);
                 r++;
             }

             return maxlen;
    }
}