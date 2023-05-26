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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dum = new ListNode();
      ListNode ans = new ListNode();
      dum = ans;
      int car = 0;

      while(l1 != null && l2 != null)
      {
          int tem = (car + l1.val + l2.val)%10;
          car = (car + l1.val + l2.val)/10;
          ans.next = new ListNode(tem);
          ans = ans.next;
          l1 = l1.next;
          l2 = l2.next;
      }

      while (l1 != null) {
          ans.next = new ListNode((l1.val + car)%10);
          car = (l1.val + car)/10;
          l1 = l1.next;
          ans = ans.next;
      }
      while (l2 != null) {
          ans.next = new ListNode((l2.val + car)%10);
          car = (l2.val + car)/10;
          l2 = l2.next;
          ans = ans.next;
      }
      if (car != 0) {
          ans.next = new ListNode(car);
      }

      return dum.next;
  }
}