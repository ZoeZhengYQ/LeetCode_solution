class Solution {
    // Time: O(n)
    // -1 代表0， 1代表1，通过加减来抵消
    // 如果之前见过这个sum说明中间的所有01都抵消了，所以可以用map
    // 存sum到第一个idx的mapping
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int cnt = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            cnt += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(cnt)) {
                max = Math.max(max, i - map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        }
        return max;
    }
}