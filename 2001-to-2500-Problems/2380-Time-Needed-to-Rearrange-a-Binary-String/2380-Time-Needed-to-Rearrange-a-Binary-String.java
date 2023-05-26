class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] sc = s.toCharArray();
        int count = 0;
        boolean flag = true;

        while (true)
        {
            flag = true;
            for (int i = 0; i < sc.length-1; i++)
            {
                if (sc[i]=='0' && sc[i+1]=='1') {
                    sc[i] = '1';
                    sc[i+1] = '0';
                    
                    if (flag) {
                        flag = false;
                        count++;
                    }
                    i++;
                }
            }
            if (flag) break;
        }

        return count;
    }
}