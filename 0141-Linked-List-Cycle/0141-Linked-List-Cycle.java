/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
      if (head == null || head.next == null || head.next.next == null) return false;

      ListNode fast = head.next.next;
      ListNode slow = head.next;
      while(slow != null && fast != null) {
          if (slow == fast) return true;
          if (slow.next == null || fast.next == null || fast.next.next == null) break;
          slow = slow.next;
          fast = fast.next.next;
      }
      return false;
  }
}