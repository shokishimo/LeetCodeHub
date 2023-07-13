class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, new int[]{i, i});
            }
            map.get(c)[1] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int count = 1;
            int dis = map.get(s.charAt(i))[1];
            int j = i + 1;

            while (j <= dis) {
                int dis2 = map.get(s.charAt(j))[1];
                dis = Math.max(dis, dis2);
                j++;
                count++;
            }
            ans.add(count);
            i = j;
        }

        return ans;
    }
}