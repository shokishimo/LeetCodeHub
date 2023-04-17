// Solution 1
class Solution {
  public int missingNumber(int[] nums) {
      int ans = 0;
      int n = nums.length;
      for (int i = 1; i <= n; i++) {
          ans += i;
      }
      for (int i = 0; i < n; i++) {
          ans -= nums[i];
      }
      return ans;
  }
}


// Solution 2
class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans += i;
            ans -= nums[i];
        }
        ans += n;
        
        return ans;
    }
}