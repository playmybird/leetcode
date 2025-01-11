import java.util.HashMap;

class LRUCache {
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    HashMap<Integer, DoubleLinkedNode> map;
    int cap;

    static class DoubleLinkedNode {
        int key;
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;

        @Override
        public String toString() {
            return val + "," + next;
        }
    }

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity + 1);
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }

    public int get(int key) {
        var n = map.get(key);
        if (n == null) {
            return -1;
        }

        moveToTail(n);
        return n.val;
    }

    public void put(int key, int value) {
        var n = map.get(key);
        if (n != null) {
            n.key = key;
            n.val = value;
            moveToTail(n);
            return;
        }

        n = new DoubleLinkedNode();
        n.val = value;
        n.key = key;
        map.put(key, n);

        addLast(n);
        if (map.size() > cap) {
            var first = removeFirst();
            map.remove(first.key);
        }
    }

    private void moveToTail(DoubleLinkedNode n) {
        remove(n);
        addLast(n);
    }

    private void addLast(DoubleLinkedNode n) {
        var next = tail;
        var prev = next.prev;
        prev.next = n;
        n.prev = prev;
        n.next = next;
        next.prev = n;
    }

    private DoubleLinkedNode removeFirst() {
        var first = head.next;
        remove(first);
        return first;
    }

    private void remove(DoubleLinkedNode n) {
        var prev = n.prev;
        var next = n.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 0);
        c.put(2, 2);
        c.get(1);
        c.put(3, 3);
        c.get(2);
        c.put(4, 4);
        c.get(1);
        c.get(3);
        c.get(4);
    }
}