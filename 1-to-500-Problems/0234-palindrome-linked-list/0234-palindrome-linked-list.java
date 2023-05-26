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
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        
        int count = 0;
        while(cur != null)
        {
            cur = cur.next;
            count++;
        }
        
        if (count == 1) return true;
        if (count == 2) {
            if (head.val == head.next.val) return true;
            else return false;
        }
        
        cur = head;
        Stack<Integer> stack = new Stack<>();
        int mid = count/2;
        for (int i = 0; i < mid; i++)
        { 
            stack.push(cur.val);
            cur = cur.next;
        }
        
        if (count%2!=0) {
            mid++;
            cur = cur.next;
        }
        for (int i = mid; i < count; i++)
        {
            int t = cur.val;
            if (stack.pop() != t) {
                return false;
            }
            cur = cur.next;
        }
        
        return true;
    }
}