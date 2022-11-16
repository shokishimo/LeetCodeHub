class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        
        return nums[nums.length-k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++)
        {
            queue.add(nums[i]);
        }

        for (int i = 0; i < k; i++)
        {
            if (i == k-1) return queue.poll();
            else queue.poll();
        }

        return -1;
    }
}