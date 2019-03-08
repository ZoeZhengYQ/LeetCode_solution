String treeToTernary(Node root) {
	StringBuilder sb = new StringBuilder();
	Stack<Node> st = new Stack<>();

	Node cur = root;

	while (cur != null || !st.isEmpty()) {
		if (cur != null) {
			sb.append(cur.val);
			if (cur.left != null && cur.right != null) {
				sb.append("?");
			}
			st.push(cur);
			cur = cur.left;
		} else {
			cur = st.pop();
			cur = cur.right;
			if (cur != null) {
				sb.append(":");
			}
		}
	}
	return sb.toString();
}