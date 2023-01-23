//start of node class
class Node {
        
    int key;
    int val;
    int freq;
    Node next;
    Node prev;
    
    Node(){
        this.next = null;
        this.prev = null;
    }
    
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.freq = 1;    
    }
}
//end of node class



//start of DoubleLinkedList class
class DoubleLinkedList {

int listSize;
Node head;
Node tail;

DoubleLinkedList(){
    this.head = new Node();
    this.tail = new Node();
    head.next = tail;
    tail.prev = head;
    listSize = 0;
}

//add a node to front
void addNode(Node node){
    
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    listSize++;
}

//remove a node
void removeNode(Node node){
    
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = null;
    node.next = null;
    listSize--;
}

}
//end of DoubleLinkedList class



//start of LFUCache class
class LFUCache {

Map<Integer, DoubleLinkedList> freqMap;
Map<Integer, Node> cache;
int maxSize;
int minFreq;

public LFUCache(int capacity) {
    
    freqMap = new HashMap<>();
    cache = new HashMap<>();
    maxSize = capacity;
    minFreq = 0;
}

public int get(int key) {
    
    if(!cache.containsKey(key)){
        return -1;
    }
    
    Node node = cache.get(key);
    incrementFreq(node);
    return node.val;
}

public void put(int key, int value) {
    
    if(maxSize == 0){
        return;
    }
    
    if(cache.containsKey(key)){
        Node node = cache.get(key);
        node.val = value;
        incrementFreq(node);
    }
    
    else{
        
        if(cache.size() == maxSize){
            DoubleLinkedList dll = freqMap.get(minFreq);
            cache.remove(dll.tail.prev.key);
            dll.removeNode(dll.tail.prev);
        }
    
        minFreq = 1;
        Node node = new Node(key,value);
        
        DoubleLinkedList dll = freqMap.getOrDefault(1, new DoubleLinkedList());
        dll.addNode(node);
        cache.put(key, node);
        freqMap.put(1, dll);
    }
}

//increment the count value of node
void incrementFreq(Node node){
    
    int currFreq = node.freq;
    DoubleLinkedList dll = freqMap.get(currFreq);
    dll.removeNode(node);
    
    if(currFreq == minFreq && dll.listSize == 0){
        minFreq++;
    }
    
    int newFreq = ++node.freq;
    if(freqMap.containsKey(newFreq)){
        dll = freqMap.get(newFreq);
        dll.addNode(node);
    }
    else{
        dll = new DoubleLinkedList();
        dll.addNode(node);
        freqMap.put(newFreq, dll);
    }
}
}

/**
* Your LFUCache object will be instantiated and called as such:
* LFUCache obj = new LFUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/