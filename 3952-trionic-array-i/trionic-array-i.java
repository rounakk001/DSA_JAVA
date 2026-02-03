class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length<3)
        return false;

       int n=nums.length-1;
       
        while(n>=1 && nums[n]>nums[n-1]){
            n--;
           
        }
       
         if(n==nums.length-1) return false;
        
        while(n>=1 && nums[n]<nums[n-1]){
            n--;
            
        }
        if(n == 0) return false;

        
       
        while(n>=1 && nums[n]>nums[n-1]){
            n--;
           
        }

        return n==0;
       

    }
}