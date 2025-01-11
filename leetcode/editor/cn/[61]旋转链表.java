//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1112 👎 0


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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        head = new ListNode(0, head);
        ListNode prev = head;
        ListNode cur = prev;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
            if (cur == null) {
                cur = head.next;
            }
        }

        while (cur.next != null) {
            prev = prev.next;
            cur = cur.next;
        }

        if (prev == head) {
            return head.next;
        }

        ListNode list2Last = cur;
        ListNode list2Head = prev.next;
        ListNode list1Last = prev;
        ListNode list1Head = head.next;

        list2Last.next = list1Head;
        list1Last.next = null;
        return list2Head;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().rotateRight(new ListNode(0, new ListNode(1)), 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
