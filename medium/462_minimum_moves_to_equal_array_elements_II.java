class Solution {
    // 所有数字都向中位数靠拢而不是向平均数靠拢！！
    // 如果直接sort就是O(nlogn)
    // using quickselect O(n)
    public int minMoves2(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1);
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }
    
    private int quickSelect(int[] arr, int start, int end) {
        int target = arr.length / 2;
        int pre = start;
        int l = start;
        int pivot = arr[start];
        while (l <= end) {
            if (arr[l] < pivot) {
                swap(arr, l, ++pre);
            }
            l++;
        }
        swap(arr, start, pre);
        if (pre == target) {
            return arr[pre];
        }
        if (pre < target) {
            return quickSelect(arr, pre + 1, end);
        }
        return quickSelect(arr, start, pre);
    }
    
    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}