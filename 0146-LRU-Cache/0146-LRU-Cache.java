class LRUCache {
  int cap;
  Node lru;
  Node mru;
  HashMap<Integer, Node> map;
  int size;

  public LRUCache(int capacity) {
      cap = capacity;
      lru = new Node(0, 0);
      mru = new Node(0, 0);
      lru.next = mru;
      mru.prev = lru;
      map = new HashMap<>();
      size = 0;
  }
  
  public int get(int key) {
      if (map.get(key) != null) {
          Node temp = map.get(key);
          temp.next.prev = temp.prev;
          temp.prev.next = temp.next;
          temp.prev = mru.prev;
          temp.next = mru;
          mru.prev = temp;
          temp.prev.next = temp;
          return temp.val;
      } else return -1;
  }
  
  public void put(int key, int value) {
      if (map.get(key) != null) {
          Node temp = map.get(key);
          temp.val = value;
          temp.next.prev = temp.prev;
          temp.prev.next = temp.next;
          temp.prev = mru.prev;
          temp.next = mru;
          mru.prev = temp;
          temp.prev.next = temp;
      } else {
          size++;
          Node t = new Node(key, value);
          t.prev = mru.prev;
          t.next = mru;
          mru.prev.next = t;
          mru.prev = t;
          map.put(key, t);
          if (cap < size) {
              Node temp = lru.next;
              lru.next = lru.next.next;
              lru.next.prev = lru;
              map.remove(temp.k);
              size--;
          }
      }
  }
}

class Node {
   int val;
   int k;
   Node next;
   Node prev;

   public Node(int key, int value) {
       k = key;
       val = value;
       next = null;
       prev = null;
   }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/