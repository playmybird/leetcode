//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
        n.key = key;
        n.val = value;
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
