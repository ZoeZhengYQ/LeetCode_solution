import java.util.*;

// 美国知乎面试题1
// 一个乱序数组，有正有负，从中选取多个数值，要求所选数值之差绝对值不能小于1（不适用于重复数值，若有重复数值，可以多选），
// 求能从数组中选出数值之和的最大值
// 用哈希表记录出现频次，再将键集合排序开始动态规划，每次选择 选/不选
// Follow up: 有界限的输入: bucket sort
public class Solution{
    private static int max = 0;
    
     public static void main(String []args){
        int[] input = new int[]{1,2,100,2,2,50,102};
        skipSum(input);
        System.out.println(max);
     }
     
     public static int skipSum(int[] nums){
         if (nums.length == 0) return 0;
         Map<Integer, Integer> cnt = new HashMap<>();
         for (int num : nums) {
             cnt.put(num, cnt.getOrDefault(num, 0) + 1);
         }
         Arrays.sort(nums);
         helper(nums, 0, -100, 0, cnt);
         return 0;
     }
     
     private static void helper(int[] nums, int idx, int last, int sum, Map<Integer, Integer> cnt) {
         if (idx >= nums.length) {
             max = Math.max(max, sum);
            //  System.out.println("Udpate max to:" + max);
             return;
         }
         int cur = nums[idx];
         int newSum = sum + cur*cnt.get(cur);
         int newIdx = idx+cnt.get(cur);
         if (cur-last > 1) { // can choose
             
             helper(nums, newIdx, cur, newSum, cnt);
         }
         // Not choose
         helper(nums, newIdx, last, sum, cnt);
     }
}