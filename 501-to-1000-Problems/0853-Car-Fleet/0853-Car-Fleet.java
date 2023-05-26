class Solution {
  public int carFleet(int target, int[] position, int[] speed) {
      int[][] info = new int[speed.length][2];
      for (int i = 0; i < speed.length; i++) {
          info[i][0] = position[i];
          info[i][1] = speed[i];
      }
      Arrays.sort(info, (a, b) -> a[0] - b[0]);
      Stack<Double> stack = new Stack<>();
      for (int i = info.length-1; i >= 0; i--)
      {   
          double time = (double)(target - info[i][0])/info[i][1];
          if (!stack.isEmpty() && stack.peek() >= time)continue;
          else stack.push(time);
      }
      return stack.size();
  }
}