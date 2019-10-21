class RandomizedSet {
    // map: value to position idx
    Map<Integer, Integer> map;
    // List of values used to get random in O(1)
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            int newVal = list.get(list.size()-1);
            list.set(idx, newVal);
            list.remove(list.size()-1);
            map.put(newVal, idx);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        // keep a arraylist so that we can use rand to get random in O(1)
        Random rand = new Random();
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */