class MinStack {

  Stack<Integer> stack;
  int min;
  HashMap<Integer, Integer> map;
  boolean isFirst;

  public MinStack() {
      stack = new Stack<>();
      map = new HashMap<>();
      isFirst = true;
  }

  public void push(int val) {
      if (isFirst) {
          isFirst = false;
          min = val;
      }
      else {
          if (min > val) min = val;
      }
      stack.push(val);
      map.put(stack.size(), min);
  }

  public void pop() {
      map.remove(stack.size());
      stack.pop();
      if (stack.isEmpty()) isFirst = true;
      else min = map.get(stack.size());
  }

  public int top() {
      return stack.peek();
  }

  public int getMin() {
      if (stack.isEmpty()) return 0;
      return min;
  }
}