class Solution {
    public int smallestRepunitDivByK(int k) {
        int  n=1;
        int c=1;
        if(k%2==0)
        return -1;

        if(k%5==0)
          return -1;

        while(!(n%k==0)){
            c++;
            n=(n*10+1)%k;
            }

   

         return c;
    }
}