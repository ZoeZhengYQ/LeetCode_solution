/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String splitter = ",";
    private String nullNode = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Pre order traversal
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {
            TreeNode curNode = st.pop();
            if (curNode == null) {
                sb.append(nullNode + splitter);
                continue;
            }
            sb.append(curNode.val + splitter);
            st.push(curNode.right);
            st.push(curNode.left);
        }
        // System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // Use Deque to keep the order
    // Recursively reconstruct the tree
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        String[] datas = data.split(splitter);
        for (int i = 0; i < datas.length; ++i) {
            nodes.addFirst(datas[i]);
        }
        return helper(nodes);
    }
    
    private TreeNode helper(Deque<String> nodes) {
        String val = nodes.removeLast();
        if (val.equals(nullNode)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = helper(nodes);
            node.right = helper(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));