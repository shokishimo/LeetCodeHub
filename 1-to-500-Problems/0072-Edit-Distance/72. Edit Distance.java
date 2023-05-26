class Solution {
  public int minDistance(String word1, String word2) {
      if (word1.length()==0 || word2.length()==0) return Math.max(word1.length(), word2.length());

      int[][] distance = new int[word1.length()+1][word2.length()+1];

      for (int i = 0; i <= word1.length(); i++) {
          distance[i][0] = i;
      }
      for (int j = 1; j <= word2.length(); j++) {
          distance[0][j] = j;
      }

      for (int i = 1; i <= word1.length(); i++)
      {
          for (int j = 1; j <= word2.length(); j++)
          {
              int replace = distance[i-1][j-1] + ((word1.charAt(i-1)==word2.charAt(j-1))? 0 : 1);
              int insert = distance[i][j-1] + 1;
              int delete = distance[i-1][j] + 1;
              distance[i][j] = Math.min(Math.min(insert, delete), replace);
          }
      }

      return distance[word1.length()][word2.length()];
  }
}