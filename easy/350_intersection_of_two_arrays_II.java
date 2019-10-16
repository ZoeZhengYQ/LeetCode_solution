class Solution {
    // HashMap count
    // Time: O(m+n)
    // Space: O(min(n, m))  better to count the smaller array
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect (nums2, nums1);
        }
        // nums1 shorter
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums1) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> resList = new ArrayList<>();
        for (int n : nums2) {
            if (count.containsKey(n) && count.get(n) > 0) {
                resList.add(n);
                count.put(n, count.get(n)-1);
            }
        }
        
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); ++i) {
            res[i] = resList.get(i);
        }
        return res;
    }
}