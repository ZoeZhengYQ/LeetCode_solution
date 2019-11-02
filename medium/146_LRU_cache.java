// LRU cache: using hashmap and double linked list
// hashmap used to see hit/miss
// double LL obeys LRU

// 64ms, 64.29%
class LRUCache {
    
    class DLLNode {
        int key; 
        int val;
        DLLNode prev;
        DLLNode next;
        
        DLLNode (int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    private final int capacity;
    private int size;
    private Map<Integer, DLLNode> map;
    private DLLNode head;
    private DLLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DLLNode node = map.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLLNode node = map.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }
        while (size >= capacity) {
            popTail();
        }
        DLLNode newNode = new DLLNode(key, value);
        map.put(key, newNode);
        addToHead(newNode);
    }
    
    // A new cache block
    private void addToHead(DLLNode node) {
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;   
        }
        size++;
        map.put(node.key, node);
    }
    
    // A new reference to a existing block
    private void moveToHead(DLLNode node) {
        if (head == node) return;
        if (tail == node) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private DLLNode popTail() {
        if (size == 0) return null;
        DLLNode node = tail;
        if (size == 1) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;    
        }
        map.remove(node.key);
        size--;
        return node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
class LRUCache {
    private int size;
    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        // printCache();
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            while (size >= capacity) {
                popTail();
            }
            
            Node newNode = new Node(key, value);
            this.map.put(key, newNode);
            addToHead(newNode);
        }
        // printCache();
        return;
    }
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    // New cache block
    private void addToHead(Node node) {
        if (size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        size++;
        map.put(node.key, node);
        return;
    }
    
    // Evict
    private Node popTail() {
        if (size == 0) {
            return null;
        }
        Node tmp = this.tail;
        this.tail = this.tail.prev;
        if (size == 1) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        size--;
        map.remove(tmp.key);
        return tmp;
    }
    
    // LRU, cache hit
    private void moveToHead(Node node) {
        
        // Already first one
        if (this.head == node) {
            return;
        } 
        // if last one
        if (this.tail == node) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            addToHead(node);
            size--;
            return;
        } 
        
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        addToHead(node);
        size--;
        return;
    }
    */
    
    /*
    private void printCache() {
        System.out.println("--------begin-----------");
        System.out.println("size: " + this.size);
        System.out.println("capacity: " + this.capacity);
        for (int key : map.keySet()) {
            Node cur = map.get(key);
            System.out.println("key: " + key);
            System.out.println("Node: " + cur.key +" " + cur.val);
        }
        
        System.out.println("---------haha----------");
        
        Node tmp = this.head;
        
        while (tmp != null) {
            System.out.println("Node: " + tmp.key +" " + tmp.val);
            tmp = tmp.next;
        }
        System.out.println("---------end----------");
    }
    */
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */