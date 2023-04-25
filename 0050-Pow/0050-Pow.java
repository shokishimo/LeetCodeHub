class Solution {
  public double myPow(double x, int n) {
      double ans = calcPower(x, Math.abs(n));
      if (n < 0) ans = (double) 1 / ans;
      return ans;
  }

  public double calcPower(double x, int n) {
      if (n == 0) return 1;
      if (n == 1) return x;
      double half = calcPower(x, n/2);
      if (n % 2 == 0) return half*half;
      else return half*half*x;
  }
}