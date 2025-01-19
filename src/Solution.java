import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }

        ListNode head = new ListNode();
        ListNode insertNode = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        Arrays.stream(lists).forEach(node -> {
            if (node == null) {
                return;
            }
            minHeap.add(node);
        });

        while (!minHeap.isEmpty()) {
            var minList = minHeap.poll();
            insertNode.next = minList;
            insertNode = minList;
            minList = minList.next;
            if (minList != null) {
                minHeap.add(minList);
            }
        }

        insertNode.next = null;
        return head.next;
    }
}