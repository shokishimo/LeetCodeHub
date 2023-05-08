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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ArrayList<ListNode> array = new ArrayList<>();
        
        ListNode cur = head;
        int counter = 0;
        
        while(cur != null)
        {
            counter++;
            array.add(cur);
            cur = cur.next;
        }
        
        ListNode ans = null;
        if (counter - n == 0) {
            ans = head.next;
        } else {
            ans = array.get(0);
            ListNode temp = array.get(counter-n-1);
            temp.next = array.get(counter-n).next;
        }
        
        return ans;
    }
}

// Solution 2
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode();
        ans.next = head;

        ListNode cur = head;
        for (int i = 0; i < n-1; i++) {
            cur = cur.next;
        }
        ListNode rm = head;
        ListNode prev = head;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            rm = rm.next;
            if (count > 0) {
                prev = prev.next;
            }
            count++;
        }

        if (rm == head) {
            ans.next = head.next;
            head.next = null;
        } else if (rm.next == null) {
            prev.next = null;
        } else {
            prev.next = rm.next;
            rm.next = null;
        }

        return ans.next;
    }
}