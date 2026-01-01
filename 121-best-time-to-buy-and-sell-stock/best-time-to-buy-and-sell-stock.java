class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0,cost =0;
        int mini=prices[0];
        for(int i=0;i<n;i++){
             cost= prices[i]-mini;
             profit=Math.max(profit,cost);

             mini=Math.min(prices[i],mini);
        }

        return  profit;
    }
    
}