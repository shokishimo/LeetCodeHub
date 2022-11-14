class Solution {
    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> map = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++)
        {
            map.add(new ArrayList<>());
        }

        if (numRows > 1)
        {
            int adjuster = 1;
            int counter = 0;
            for (int i = 0; i < s.length(); i++)
            {
                if (counter == numRows-1) adjuster = -1;
                else if (counter == 0) adjuster = 1;
                map.get(counter).add(s.charAt(i));
                counter += adjuster;
            }
        } 
        else 
        {       
            for (int i = 0; i < s.length(); i++)
            {
                map.get(0).add(s.charAt(i));
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.size(); i++)
        {
            for (int j = 0; j < map.get(i).size(); j++)
            {
                sb.append(map.get(i).get(j));
            }
        }

        return sb.toString();
    }
}