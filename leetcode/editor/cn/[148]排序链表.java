//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2429 👎 0


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
    public ListNode sortList(ListNode head) {
        return sortAndMerge(head, null);
    }

    private ListNode sortAndMerge(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }

        if (head == tail) {
            return new ListNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            if (fast == tail) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }

        ListNode l = sortAndMerge(head, slow);
        ListNode r = sortAndMerge(slow.next, tail);

        ListNode merged = new ListNode();
        ListNode insertNode = merged;
        while (l != null && r != null) {
            if (l.val < r.val) {
                insertNode.next = l;
                insertNode = l;
                l = l.next;
            } else {
                insertNode.next = r;
                insertNode = r;
                r = r.next;
            }
        }

        if (l == null) {
            insertNode.next = r;
        } else {
            insertNode.next = l;
        }

        return merged.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
