//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1338 👎 0


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
    public ListNode deleteDuplicates(ListNode head) {
        head = new ListNode(0, head);

        ListNode prev = head;
        while (true) {
            ListNode cur = prev.next;
            if (cur == null) {
                break;
            }

            ListNode next = cur.next;
            if (next == null) {
                break;
            }

            while (next != null && next.val == cur.val) {
                next = next.next;
            }

            if (next == cur.next) {
                // no same
                prev = cur;
            } else {
                // has same;
                prev.next = next;
            }

        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
