class Solution {
  public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<Integer>();
      int a;
      int b;
      for (String each: tokens)
      {
          if (each.equals("+")) {
              b = stack.pop();
              a = stack.pop();
              a += b;
              stack.push(a);
          } else if (each.equals("-")) {
              b = stack.pop();
              a = stack.pop();
              a -= b;
              stack.push(a);
          } else if (each.equals("*")) {
              b = stack.pop();
              a = stack.pop();
              a *= b;
              stack.push(a);
          } else if (each.equals("/")) {
              b = stack.pop();
              a = stack.pop();
              a /= b;
              stack.push(a);
          } else {
              stack.push(Integer.parseInt(each));
          }
      }

      return stack.pop();
  }
}