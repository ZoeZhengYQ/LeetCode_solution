/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    // Preorder traversal!
    // Using recursive and record number of child after every node 
    // So that we know where to stop
    // Time: O(n)
    // Space: O(n)

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        sHelper(sb, root);
        String data = sb.toString();
        data = data.substring(0, data.lastIndexOf(","));
        return data;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) return null;
        String[] arr = data.split(","); 
        Queue<Integer> q = new LinkedList<>();
        for (String str : arr) {
            q.offer(Integer.valueOf(str));
        }
        return deHelper(q);
    }
    
    private void sHelper(StringBuilder sb, Node node) {
        sb.append(node.val + "," + node.children.size() + ",");
        for (Node child : node.children) {
            sHelper(sb, child);
        }
    }
    
    private Node deHelper(Queue<Integer> q) {
        Node node = new Node();
        node.val = q.poll();
        node.children = new ArrayList<Node>();
        int childCnt = q.poll();
        for (int i = 0; i < childCnt; ++i) {
            node.children.add(deHelper(q));
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));