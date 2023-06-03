/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
  public Node cloneGraph(Node node) {
      if (node == null) return null;
      Node dummy = new Node();
      HashMap<Integer, Node> map = new HashMap<>();
      Node t = new Node(node.val);
      map.put(node.val, t);
      dummy.neighbors.add(t);
      HashSet<Integer> set = new HashSet<>();
      set.add(node.val);

      dfs(node, t, map, set);

      return dummy.neighbors.get(0);
  }

  private void dfs(Node node, Node cur, HashMap<Integer, Node> map, HashSet<Integer> set) {
      for (Node each: node.neighbors) {
          Node temp;
          if (map.get(each.val) == null) {
              temp = new Node(each.val);
              map.put(each.val, temp);
          }
          temp = map.get(each.val);
          cur.neighbors.add(temp);
          if (set.contains(each.val)) continue;
          set.add(each.val);
          node = each;
          dfs(node, temp, map, set);
      }
  }
}