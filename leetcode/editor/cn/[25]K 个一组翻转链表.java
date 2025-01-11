//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2465 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        head = new ListNode(0, head);

        ListNode insertHead = head;
        while (true) {
            int len = k;
            ListNode cur = insertHead;

            while (cur.next != null && len > 0) {
                cur = cur.next;
                len--;
            }

            if (len > 0) {
                break;
            }

            ListNode last = cur;
            ListNode next = last.next;
            last.next = null;

            last = insertHead.next;
            cur = last.next;
            last.next = next;

            while (cur != null) {
                ListNode n = cur.next;

                cur.next = insertHead.next;
                insertHead.next = cur;

                cur = n;
            }

            insertHead = last;
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
