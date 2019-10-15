class RandomizedCollection {
    // Time: O(1)
    // Space: O(n)
    class Node {
        int idx;
        int val;
        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    
    private Map<Integer, Node> idxMap;  // Idx and node mapping, used in getRandom()
    private Map<Integer, Queue<Node>> valMap;   // Value to list of node mapping, used in insert and remove to determine return value
    
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.idxMap = new HashMap<>();
        this.valMap = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int idx = idxMap.size();
        Node node = new Node(idx, val);
        if (valMap.containsKey(val)) {  // Already have one, add to list
            valMap.get(val).add(node);
            idxMap.put(idx, node);
            return false;
        }
        // Create new mapping and add node to it
        Queue<Node> tmp = new LinkedList<>();
        tmp.add(node);
        valMap.put(val, tmp);
        idxMap.put(idx, node);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // Empty map or no value existed
        if (idxMap.isEmpty() || !valMap.containsKey(val)) return false;
        
        int lastIdx = idxMap.size() - 1;
        // Exchange idx of last one to current one, for the purpost of random range 
        //      and always use the size of idMap as the next value index
        Node toRemove = valMap.get(val).remove();
        if (valMap.get(val).size() == 0) {
            valMap.remove(val);
        }
        Node lastNode = idxMap.get(lastIdx);
        idxMap.remove(lastNode.idx);
        // Only exchange when current to remove node is NOT the last node!
        //  Otherwise it would be added again
        if (lastNode.idx != toRemove.idx) {
            lastNode.idx = toRemove.idx;
            idxMap.put(lastNode.idx, lastNode);   
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random gen = new Random();
        int random = gen.nextInt(idxMap.size());
        return idxMap.get(random).val;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */