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
  public void reorderList(ListNode head) {
      if (head == null || head.next == null) return;

      ListNode back = null;
      ListNode cur = head;
      int len = 0;

      while (cur != null)
      {
          ListNode temp = new ListNode(cur.val);
          temp.next = back;
          back = temp;
          cur = cur.next;
          len++;
      }

      ListNode forw = head.next;
      ListNode ans = head;
      ListNode dum = new ListNode();
      dum.next = ans;
      int i = 1;
      while (i < len)
      {
          if (i % 2 == 0)
          {
              ans.next = forw;
              forw = forw.next;
          }
          else 
          {
              ans.next = back;
              back = back.next;
          }
          ans = ans.next;
          i++;
      }
      ans.next = null;
      head = dum.next;
  }
}