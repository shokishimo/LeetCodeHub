class Solution {
  public int[] twoSum(int[] numbers, int target) {
      int[] ans = new int[] {-1, -1};
      if (numbers.length < 2) return ans;

      int left = 0;
      int right = numbers.length-1;

      while (left < right)
      {
          int sum = numbers[left] + numbers[right];
          if (sum == target) return new int[] {left+1, right+1};
          else if (sum < target) left++;
          else right--;
      }

      return ans;
  }
}