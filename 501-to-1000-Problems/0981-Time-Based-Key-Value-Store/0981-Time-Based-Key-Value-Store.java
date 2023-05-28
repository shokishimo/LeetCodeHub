class TimeMap {

  HashMap<String, ArrayList<Integer>> keyTime;
  HashMap<String, String> keyValue;

  public TimeMap() {
      keyTime = new HashMap<>();
      keyValue = new HashMap<>();
  }
  
  public void set(String key, String value, int timestamp) {
      if (keyTime.get(key) == null) 
          keyTime.put(key, new ArrayList<>());

      int[] pos = findPosition(key, timestamp);
      keyTime.get(key).add(pos[1], timestamp);
      String k = key + timestamp;
      keyValue.put(k, value);
  }
  
  public String get(String key, int timestamp) {
      String k = key + timestamp;
      if (keyValue.get(k) != null) return keyValue.get(k);
      if (keyTime.get(key) == null) return "";
      int[] pos = findPosition(key, timestamp);
      if (pos[0] == -1) pos[1]--;
      if (pos[1] == -1) return "";       
      k = key + keyTime.get(key).get(pos[1]);
      return keyValue.get(k);
  }

  private int[] findPosition(String key, int target) {
      int l = 0;
      int r = keyTime.get(key).size();

      while(l < r) {
          int m = (l + r)/2;
          if (keyTime.get(key).get(m) == target)
              return new int[] {0, m};
          if (keyTime.get(key).get(m) < target)
              l = m + 1;
          else 
              r = m;
      }
      return new int[] {-1, l};
  }
}

/**
* Your TimeMap object will be instantiated and called as such:
* TimeMap obj = new TimeMap();
* obj.set(key,value,timestamp);
* String param_2 = obj.get(key,timestamp);
*/