class Solution {

    public int func(int piles[],int hourly){
        int c=0;
        for(int i=0;i<piles.length;i++){
            c+=Math.ceil((double)(piles[i])/(double)(hourly));
        }
        return c;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int max= Arrays.stream(piles).max().getAsInt();
        int n=piles.length;
        int low=1;
        int high=max;
         int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int totalhours=func(piles,mid);
            if(totalhours<=h){
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }

        return ans;

    }
}