class Solution {
    public int firstUniqChar(String s) {

        Cmap[] arr = new Cmap[26];
        for (int i = 0; i < s.length(); i++) {
            int index = (int)(s.charAt(i)-'a');
            if (arr[index] != null) {
                arr[index].count++;
            } else {
                arr[index] = new Cmap(1, i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i<arr.length; i++)
        {
            if (arr[i] != null && arr[i].count == 1 && min > arr[i].num) {
                min = arr[i].num;
            }
        }

        if (min == Integer.MAX_VALUE) return -1;
        else return min;

    }
}

class Cmap
{
    int count;
    int num;
    public Cmap (int c, int n)
    {
        count = c;
        num = n;
    }
}