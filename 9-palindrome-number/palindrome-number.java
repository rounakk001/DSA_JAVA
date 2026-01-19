class Solution {
    public boolean isPalindrome(int x) {
        int a=x;
        int r=0;
        if(a==0){
            return true;
        }
        if(a>0){
        while(x!=0){
            int z=x%10;
            r=(r*10)+z;
            x=x/10;
        }
        if(r==a){
            return true;
        }
        else
        return false;

        }
        else
        return false;
        
    }
}