class Solution {
    public void reverse(int arr[],int start,int end){
              while(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;

                start++;
                end--;
              }
    }
    public void nextPermutation(int[] nums) {
         int n=nums.length;

         int idx=-1;
        

         for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;   ///here we will find breakpoint
            }
         }

         if(idx==-1)
         reverse(nums,0,n-1);

         else{

         for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
         }

         reverse(nums,idx+1,n-1);
         }

         
    }
}