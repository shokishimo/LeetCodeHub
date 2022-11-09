class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        StringBuilder ans = new StringBuilder();
        int max = 0;
        for (int i = 0; i < shifts.length; i++)
        {
            max = (max + shifts[i]) % 26;
        }
        
        for (int i = 0; i < shifts.length; i++)
        {
            ans.append( (char)((s.charAt(i)-'a' + max) % 26 + 'a') );
            max = Math.floorMod(max - shifts[i], 26);
        }

        return ans.toString();
    }
}