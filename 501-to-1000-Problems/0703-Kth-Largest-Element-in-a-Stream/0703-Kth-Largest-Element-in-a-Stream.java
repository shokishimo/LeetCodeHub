// resolve
class KthLargest {
    PriorityQueue<Integer> pqMin;
    int theK;

    public KthLargest(int k, int[] nums) {
        pqMin = new PriorityQueue<>((a, b) -> a - b);
        theK = k;
        for (int num : nums) {
            pqMin.add(num);
            if (pqMin.size() > k) pqMin.poll();
        }
    }

    public int add(int val) {
        pqMin.add(val);
        if (pqMin.size() > theK) pqMin.poll();
        return pqMin.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */