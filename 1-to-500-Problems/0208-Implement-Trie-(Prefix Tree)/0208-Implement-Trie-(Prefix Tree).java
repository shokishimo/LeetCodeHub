class Trie {
  TrieNode root;

  public Trie() {
      root = new TrieNode();    
  }
  
  public void insert(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
          int index = word.charAt(i) - 'a';
          if (cur.children[index] == null)
              cur.children[index] = new TrieNode();
          cur = cur.children[index];
      }
      cur.isEnd = true;
  }
  
  public boolean search(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
          int index = word.charAt(i) - 'a';
          if (cur.children[index] == null) return false;
          cur = cur.children[index];
      }
      return cur.isEnd;
  }
  
  public boolean startsWith(String prefix) {
      TrieNode cur = root;
      for (int i = 0; i < prefix.length(); i++) {
          int index = prefix.charAt(i) - 'a';
          if (cur.children[index] == null) return false;
          cur = cur.children[index];
      }
      return true;
  }
}

class TrieNode {
  boolean isEnd;
  TrieNode[] children;

  TrieNode() {
      isEnd = false;
      children = new TrieNode[26];
  }
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/