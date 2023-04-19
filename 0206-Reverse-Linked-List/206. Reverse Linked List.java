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
  public ListNode reverseList(ListNode head) {
      if (head == null) return head;
      ListNode ans = new ListNode();
      ListNode temp = new ListNode(head.val);
      head = head.next;

      while(head != null)
      {
          ListNode t = new ListNode(head.val);
          t.next = temp;
          temp = t;
          head = head.next;
      }

      ans.next = temp;
      return ans.next;
  }
}