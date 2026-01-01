class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        int c=nums.length-1;
        while(k!=0){
        res=nums[c];
        c--;
        k--;
        }
        return res;
    }
}