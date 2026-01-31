class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,maxlen=0;;
        for(int i=0;i<n;i++){
            int zeros=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0)
                    zeros++;
                    if(zeros<=k)
                    maxlen=Math.max(j-i+1,maxlen);
                    else
                    break;
                
               

            }
        }
        return maxlen;
    }
}