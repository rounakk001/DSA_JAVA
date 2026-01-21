class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int prefixmin[]=new int[prices.length];
        int profit=0;
        int maxprofit=0;

        prefixmin[0]=prices[0];

        for(int i=1;i<n;i++){
           prefixmin[i]=Math.min(prices[i],prefixmin[i-1]);
        }
 
        for(int j=0;j<n;j++){
             profit=prices[j]-prefixmin[j];
             maxprofit=Math.max(profit,maxprofit);
        }

        return maxprofit;
    }
}