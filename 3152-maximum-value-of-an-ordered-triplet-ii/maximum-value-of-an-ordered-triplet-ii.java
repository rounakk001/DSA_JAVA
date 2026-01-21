class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;

        int prefixmax[]=new int[n];
        int suffixmax[]=new int[n];

        prefixmax[0]=nums[0];
        suffixmax[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
           prefixmax[i]=Math.max(nums[i],prefixmax[i-1]);
        }

         for(int i=n-2;i>=0;i--){
           suffixmax[i]=Math.max(nums[i],suffixmax[i+1]);
        }
     long maxsum=0;
     long sum=0;

        for(int j=1;j<n-1;j++){
         sum=(long)(prefixmax[j-1]-nums[j])*suffixmax[j+1];
         maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
}