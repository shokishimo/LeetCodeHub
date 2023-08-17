class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            int maxCount = 0;
            for (Map.Entry<Character, Integer> each : count.entrySet()) {
                maxCount = Math.max(maxCount, each.getValue());
            }

            while((r-l+1) - maxCount > k) {
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}