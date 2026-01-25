class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        

        int maxlen=0;

        for(int key:set){
            if(!set.contains(key-1)){
                int curr=key;
                int cnt=1;
                
               while(set.contains(curr+1)){
                curr++;
                cnt++;
               }

               maxlen=Math.max(cnt,maxlen);
            }

            
           
        }

        return maxlen;

        
    }
}