class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length<3)
        return false;

       int n=nums.length-1;
       
        while(n>=1 && nums[n]>nums[n-1]){
            n--;
           
        }
       
         if(n==nums.length-1)  //n=nums.length-1 matlab ki n ki value change hi nahi hui jise pata lagta hai ki decresing part present hi nahi hai
         return false;
        
        while(n>=1 && nums[n]<nums[n-1]){
            n--;
            
        }

        if(n == 0)  // iska matlab ki 
        return false;

        
       
        while(n>=1 && nums[n]>nums[n-1]){
            n--;
           
        }

        return n==0;
       

    }
}