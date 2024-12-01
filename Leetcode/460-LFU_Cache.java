class LFUCache {
    private class Node {
        int key;
        int value;
        Node prev = null;
        Node next = null;
        int freq = 0;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private void add(Node head, Node tail, Node n) {
        Node prev = tail.prev;
        n.next = tail;
        n.prev = prev;
        tail.prev = n;
        prev.next = n;
    }

    private Node delete(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;

        return n;
    }

    private Node deleteLRUNodeWithFreq(Node head, Node tail, int freq) {
        Node temp = head;
        Node rem = null;

        while (temp != null) {
            if (freq == temp.freq) {
                rem = delete(temp);
                break;
            }
            temp = temp.next;
        }
        return rem;
    }

    private void operateFreqMap(HashMap<Integer, HashSet<Node>> freqMapping, Node n, int freq, boolean add) {
        HashSet<Node> freqList = freqMapping.getOrDefault(freq, new HashSet());
        if (add) {
            freqList.add(n);
        } else {
            freqList.remove(n);
        }
        freqMapping.put(n.freq, freqList);
    }

    private int k;
    private Node head;
    private Node tail;
    private int minFreq;
    private HashMap<Integer, Node> keyMapping; // key x Node
    private HashMap<Integer, HashSet<Node>> freqMapping; // freq x Node

    public LFUCache(int capacity) {
        k = capacity;
        head = new Node(-100, -1);
        tail = new Node(-10, -1);
        minFreq = 0;
        head.next = tail;
        tail.prev = head;
        keyMapping = new HashMap();
        freqMapping = new HashMap();
    }

    public int get(int key) {
        if (keyMapping.containsKey(key)) {
            Node got = keyMapping.get(key);
            operateFreqMap(freqMapping, got, got.freq, false); // REMOVE
            delete(got); // DELETE
            add(head, tail, got); // ADD
            got.freq++; // UPDATE ITS FREQUENCY
            operateFreqMap(freqMapping, got, got.freq, true); // ADD AGAIN TO FREQ MAP
            if (freqMapping.get(got.freq - 1) == null || freqMapping.get(got.freq - 1).size() == 0) {
                if (minFreq == got.freq - 1) {
                    minFreq = got.freq;
                }
            }
            return got.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (keyMapping.containsKey(key)) {
            // if its there then update only
            Node got = keyMapping.get(key);
            operateFreqMap(freqMapping, got, got.freq, false);
            delete(got);
            add(head, tail, got);
            got.freq++;
            if (freqMapping.get(got.freq - 1) == null || freqMapping.get(got.freq - 1).size() == 0) {
                if (minFreq == got.freq - 1) {
                    minFreq = got.freq;
                }
            }
            got.value = value;
            operateFreqMap(freqMapping, got, got.freq, true);
        } else {

            if (k == keyMapping.size()) {
                HashSet<Node> lists = new HashSet();
                lists = freqMapping.getOrDefault(minFreq, new HashSet());

                if (lists.size() == 1) {
                    Iterator<Node> iterator = lists.iterator();
                    Node rem = iterator.next();
                    iterator.remove();
                    freqMapping.put(minFreq, lists);
                    delete(rem);
                    keyMapping.remove(rem.key);

                    // Now Add
                } else {
                    Node rem = deleteLRUNodeWithFreq(head, tail, minFreq);
                    operateFreqMap(freqMapping, rem, rem.freq, false);
                    keyMapping.remove(rem.key);
                }

            }
            Node newNode = new Node(key, value);
            newNode.freq = 1;
            add(head, tail, newNode);
            keyMapping.put(key, newNode);
            operateFreqMap(freqMapping, newNode, 1, true);
            minFreq = newNode.freq;

        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */