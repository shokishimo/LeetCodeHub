class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            }
            else {
                map.put(c, i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int each : map.values())
        {
            if (each != -1) {
                ans = Math.min(ans, each);
            }
        }
        if (ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }
}