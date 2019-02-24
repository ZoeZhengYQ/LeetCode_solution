class Solution {
    
    // using min-heap and maintain size as k
    // Time: O(n logk)
    // note: using max heap we need to insert all element and find the k largest
    // so time should be O(n logn)
    /*
    class Result {
        int num;
        int times;
        Result(int num, int times) {
            this.num = num;
            this.times = times;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Result> pq = new PriorityQueue<Result>(k, new Comparator<Result>() {
            @Override
            // min-heap
            public int compare(Result a, Result b) {
                return a.times - b.times;
            }
        });
        
        Arrays.sort(nums);
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == cur) {
                count++;
            } else {
                pq.offer(new Result(cur, count));
                if (pq.size() > k) { pq.poll(); }
                cur = nums[i];
                count = 1;
            }
        }
        // add the last one
        pq.offer(new Result(cur, count));
        if (pq.size() > k) { pq.poll(); }
        
        List<Integer> res = new ArrayList<> ();
        for (Result r : pq) {
            res.add(r.num);
            // System.out.println(r.num + " " + r.times);
        }
        return res;
    }
    */
    
    // bucket sort solution
    // Time: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        
        // count the frequency
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        // using frequence as the index this time
        // so the length of the bucket is no more than nums.length
        // because the max frequence would be nums.length
        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0 && res.size() < k; --i) {
            if (bucket[i] == null) continue;
            res.addAll(bucket[i]);
        }
        return res;
    }
    
}