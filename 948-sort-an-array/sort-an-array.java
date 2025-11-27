class Solution {

    public int[] merge(int nums[], int low, int mid, int high) {

        int arr[] = new int[nums.length];
        int left = low;
        int right = mid + 1;
        int k = low;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                arr[k] = nums[left];
                left++;
            } else {
                arr[k] = nums[right];
                right++;
            }
            k++;
        }

        while (left <= mid) {
            arr[k] = nums[left];
            left++;
            k++;
        }

        while (right <= high) {
            arr[k] = nums[right];
            right++;
            k++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }

    public int[] mergesort(int[] nums, int low, int high) {
        if (low == high)
            return nums;

        int mid = (low + high) / 2;

        mergesort(nums, low, mid);
        mergesort(nums, mid + 1, high);

        return merge(nums, low, mid, high);
    }

    public int[] sortArray(int[] nums) {
        return mergesort(nums, 0, nums.length - 1);
    }
}
