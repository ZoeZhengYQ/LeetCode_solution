/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    // deep copy using DFS
    // the hashmap is used to record visited info, and also help record the cloned node
    
    private Map<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return deepCopyHelper(node);
    }
    
    private Node deepCopyHelper(Node node) {
        if (node == null) return null;
        
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        
        // if not created
        Node cloneNode = new Node(node.val, new ArrayList<Node>()); 
        map.put(cloneNode.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            // remember to recursively clone neighbors
            cloneNode.neighbors.add(deepCopyHelper(neighbor));
        }
        return cloneNode;
    }
    
    
    // using BFS
    // a queue to perform BFS
    // a map to record visited node and its reference
    // 2ms
    /*
    private Queue<Node> queue = new LinkedList<>();
    private Map<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        queue.add(node);
        Node res = null;
        while (!queue.isEmpty()) {
            Node tmp = queue.remove();
            Node cloneNode = (map.containsKey(tmp.val))? 
                map.get(tmp.val) : new Node(tmp.val, new ArrayList<Node>());
            
            if (res == null) res = cloneNode;
            map.put(cloneNode.val, cloneNode);
            
            Node cloneNeighbor = null;
            for (Node neighbor : tmp.neighbors) {
                // if not created
                if (!map.containsKey(neighbor.val)) {
                    cloneNeighbor = new Node(neighbor.val, new ArrayList<Node>());
                    map.put(cloneNeighbor.val, cloneNeighbor);
                    queue.add(neighbor);
                } else {
                    cloneNeighbor = map.get(neighbor.val);
                }
                cloneNode.neighbors.add(cloneNeighbor);
            }
        }
        return res;
    }
    */
}