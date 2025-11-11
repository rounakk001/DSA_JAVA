class Solution {
    public int xorOperation(int n, int start) {
        int c=0;
        while(n!=0){
          c=c^start;
            start+=2;
            n--;
        }
        return c;
    }
}