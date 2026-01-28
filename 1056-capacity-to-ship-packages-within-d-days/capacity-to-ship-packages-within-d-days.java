class Solution {

    public int totaldays(int weights[], int mid) {
        int sum = 0;
        int c = 1; 

        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] <= mid) {
                sum += weights[i];
            } else {
                c++;              
                sum = weights[i];
            }
        }
        return c;
    }

    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE;
        int high = 0;

        for (int p : weights) {
            max = Math.max(p, max);
            high += p;
        }

        int low = max;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int capacity = totaldays(weights, mid);

            if (capacity <= days) {
                ans = mid;        
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
