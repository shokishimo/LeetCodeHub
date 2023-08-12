// resolve

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> eachMap : map.entrySet()) {
            pq.add(eachMap);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        int i = k;
        while (!pq.isEmpty()) {
            ans[--i] = pq.poll().getKey();
        }
        return ans;
    }
}