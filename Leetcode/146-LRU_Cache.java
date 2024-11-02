class Node {
    int key;
    int val;
    Node next = null;
    Node prev = null;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    public void add(Node head, Node tail, Node nn) {
        // add node just before tail in O(1)
        Node tm1 = tail.prev;

        tm1.next = nn;
        nn.prev = tm1;
        nn.next = tail;
        tail.prev = nn;
    }

    public void delete(Node head, Node n) {
        // delete given node in O(1)

        Node nm1 = n.prev;
        Node np1 = n.next;

        n.prev = null;
        n.next = null;

        nm1.next = np1;
        np1.prev = nm1;
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(0, 0);
    int k;
    HashMap<Integer, Node> hm;

    public LRUCache(int capacity) {
        k = capacity;
        hm = new HashMap();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (hm.containsKey(key)==false) {
            return -1;
        } else {
            Node n = hm.get(key);
            delete(head,n);
            add(head, tail, n);
            return n.val;
        }
    }

    public void put(int key, int value) {
        Node exist = hm.get(key);

        if (exist == null) {
            if (hm.size() == k) {
                // full
                Node del = head.next;
                delete(head, del);
                hm.remove(del.key);
            }
            // has space
            Node n = new Node(key, value);
            add(head, tail, n);
            hm.put(key, n);

        } else {
            delete(head, exist);
            exist.val = value;
            add(head, tail, exist);
            hm.put(key, exist);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */