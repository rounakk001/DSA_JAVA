
class Solution {
    public int count(int[] nums,int maxsum){
        int partition =1;
        int sum=0;

        for(int num:nums){
         if(sum+num<=maxsum){
            sum+=num;
         }
         else{
         partition++;;
         sum=num;
         }

        }
        return partition;
    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE,high=0;

          for(int num:nums){
              high+=num;
                low=Math.max(low,num);
          }
          
          

          while(low<=high){
            int mid=low+(high-low)/2;

            int partition=count(nums,mid);

            if(partition>k){
                low=mid+1;
            }
            else
            high=mid-1;
          }
           return low; 

    }
}