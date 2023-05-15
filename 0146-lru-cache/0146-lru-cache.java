
class Node {
    int key;
    int val;
    Node prev, next;
    public Node(int key, int val)
    {
        this.key=key;
        this.val=val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int cap;
    Node left;
    Node right;
    Map<Integer, Node> cache;
    public LRUCache(int capacity) 
    {
        cap = capacity;
        cache = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
        System.out.println(cap);
    }
    private void remove(Node node)
    {
        Node nxt = node.next;
        Node prv =node.prev;
        node.prev.next = nxt;
        node.next.prev = prv;
    }
    private void insert(Node node)
    {
        Node nxt = right;
        Node prv = right.prev;
        prv.next = node;
        nxt.prev = node;
        node.next = nxt;
        node.prev = prv;
    }
    public int get(int key) {
        if (cache.containsKey(key))
        {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (cache.containsKey(key))
        {remove(cache.get(key));}

        cache.put(key, new Node(key,value));
        insert(cache.get(key));

        if (cache.size()>cap)
        {   Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */