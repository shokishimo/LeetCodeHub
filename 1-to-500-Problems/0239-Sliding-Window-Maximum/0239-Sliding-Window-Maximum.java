class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int l = 0;
        int ind = 0;

        for (int r = 0; r < nums.length; r++) {
            if (!deque.isEmpty() && deque.peekFirst() < l)
                deque.pollFirst();

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r])
                deque.pollLast();
            deque.offerLast(r);

            if (r >= k - 1) {
                ans[ind++] = nums[deque.peekFirst()];
                l++;
            }
        }

        return ans;
    }
}