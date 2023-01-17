class Node {
    
    int key;
    int value;
    Node next;
    Node prev;
    
    //constructor
    Node() {
        
        this.key = 0;
        this.value = 0;
        this.next = null;
        this.prev = null;
        
    }
    
    //parameterized constructor
    Node(int key, int value) {
        
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
        
    }
    
}

class LRUCache {
    
    //adding node to the front
    void addFront(Node node) {
        
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        
    }
    
    //removing a node
    void remove(Node node) {
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        
    }
    
    //moving a node to the front(most recently used)
    void moveToFront(Node node) {
        
        remove(node);
        addFront(node);
        
    }
    
    Node head = new Node();
    Node tail = new Node();
    int maxSize;
    Map<Integer, Node> cache;
    

    public LRUCache(int capacity) {
        
        maxSize = capacity;
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)){
            return -1;
        }
        
        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        
        //if already present then update the value
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }
        
        else{    
            
            Node node = new Node(key, value);
            
            //removing LRU node and setting new node to the front
            if(cache.size() == maxSize){
                cache.remove(tail.prev.key);
                remove(tail.prev);
                addFront(node);
                cache.put(key, node);
                return;
            }
        
            //if size not full then just add new node to front
            addFront(node);
            cache.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */