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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode ans = head.next;
        ListNode cur = head;
        
        while (cur != null && cur.next != null)
        {
            ListNode temp = cur.next.next;
            cur.next.next = cur;
            if (temp == null) {
                cur.next = null;
                break;
            } else if (temp.next != null) {
                cur.next = temp.next;
            } else {
                cur.next = temp;
            }
            cur = temp;
        }
        
        
        return ans;
    }
}