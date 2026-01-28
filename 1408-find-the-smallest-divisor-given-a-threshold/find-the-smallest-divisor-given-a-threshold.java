class Solution {

    public int func(int nums[],int j){
        int c=0;
        for(int i=0;i<nums.length;i++){
          c+=Math.ceil((double)(nums[i])/(double)(j));
            }

            return c;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;
           for(int n:nums){
             high=Math.max(high,n);
           }
          int ans=high;
           while(low<=high){
            int mid=low+(high-low)/2;
            int sum=func(nums,mid);
            if(sum<=threshold){
            high=mid-1;    //divisor chota dhundhna hai to high ko mid-1 karenge
            ans=mid;
           }
           else
           low=mid+1;
           }

           return ans;
         
          
    }
}