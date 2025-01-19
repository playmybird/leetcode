//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2942 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
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
//leetcode submit region end(Prohibit modification and deletion)
