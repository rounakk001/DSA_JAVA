class Solution {

    public boolean ispossible(int[] bloomday,int day,int m,int k){
        int count=0;
        int bouquet=0;

        for(int bloom:bloomday){
            if(bloom<=day){
                count++;
                if(count==k){
                bouquet++;
                count=0;
                }
            }
            else
            count=0;
            }
              return bouquet>=m;
        }

      

        
    
    public int minDays(int[] bloomDay, int m, int k) {
         int total_flowers=m*k;

         if(total_flowers>bloomDay.length)
         return -1;

          int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

         for(int i:bloomDay){
             min=Math.min(i,min);
             max=Math.max(i,max);
         }

         int low=min,high=max,result=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(ispossible(bloomDay,mid,m,k)){
                result=mid;
                high=mid-1;
            }
            else
            low=mid+1;
            
        }

        return result;
    }
}