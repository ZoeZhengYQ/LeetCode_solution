class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        // range是左边部分idx + 1，即为length
        int range = partition(nums);
        
        // 初始化为第range + 1，即前面range个都出现了
        // 如果没有更新这就是答案
        int res = range + 1;
        
        // System.out.println("Range: " + range);
        for (int i = 0; i < range; ++i) {
            int idx = Math.abs(nums[i]);
            if (idx > 0 && idx <= range) {
                // 每个数字的状态都记录在i-1那边，因为array是从[0, range)算的
                // 一共range个，答案的范围是[1, range+1]
                // 注意如果原本是0得用-1来标记
                nums[idx-1] = (nums[idx-1] == 0)? -1 : -Math.abs(nums[idx-1]);    
            }
        }
        
        // 搜索完[1, range]， 如果没有那答案就是range + 1
        for (int i = 0; i < range; ++i) {
            if (nums[i] > 0) {
                // 因为记录的时候有1的偏移，所以答案应该是i+1
                res = i+1;
                break;
            }
        }
        return res;
    }
    
    
    
    
    
    // put all the element that is less or equal to 0 to the right
    // return index of the left part + 1
    private int partition(int[] arr) {
        int r = arr.length - 1;
        int l = 0;
        
        while (r >= 0 && arr[r] <= 0) {
            r--;    // now r is the pointer to the right irrelavent part
        }
        
        // 注意这边是<=, 否则很可能l=r那个其实也是大于0但是没有算到range里面
        while (l <= r) {
            if (arr[l] <= 0) {
                swap(arr, l, r);
                while (r >= 0 && arr[r] <= 0) {
                    r--;
                }
            }
            l++;
        }
        return l;
    }
    
    // swap新思路！！
    private void swap(int[] arr, int x, int y) {
        arr[x] ^= arr[y];
        arr[y] ^= arr[x];
        arr[x] ^= arr[y];
    }
}