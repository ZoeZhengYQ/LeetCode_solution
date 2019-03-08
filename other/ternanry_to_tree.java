Node ternaryToTree(String exp) {
    Stack stack = new Stack();
    Node node = new Node();
    stack.push(node);
    for(int i = 0; i < exp.length(); i++) {
        char c = exp.charAt(i);
        if(c == '?') {
            stack.peek().left = new Node();
            stack.push(stack.peek().left);
        } else if(c == ':') {
            stack.pop();
            while (stack.peek().right != null) {
                stack.pop();
            }    
            stack.peek().right = new Node();
            stack.push(stack.peek().right);
        } else {
            stack.peek().val = c;
        }
    }
    return node;
}