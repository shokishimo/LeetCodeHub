// resolve
// O(n log k)
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

// solution 2
// O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> freqList[] = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> eachMap : map.entrySet()) {
            if (freqList[eachMap.getValue()] == null)
                freqList[eachMap.getValue()] = new ArrayList<>();
            freqList[eachMap.getValue()].add(eachMap.getKey());
        }

        int[] ans = new int[k];
        int ind = 0;
        for (int i = freqList.length-1; i >= 0; i--) {
            if (freqList[i] != null) {
                for (int eachVal : freqList[i]) {
                    ans[ind++] = eachVal;
                    if (ind >= k) return ans;
                }
            }
        }
        return ans;
    }
}