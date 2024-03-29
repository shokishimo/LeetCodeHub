// Solution 1 Dijkstra's Algorithm
class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time: times) {
            int src = time[0];
            int tar = time[1];
            int t = time[2];
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Pair(t, tar));
        }

        int[] signalR = new int[n+1];
        Arrays.fill(signalR, Integer.MAX_VALUE);

        dijkstra(signalR, k, n);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalR[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dijkstra(int[] signalR, int source, int n) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        pq.add(new Pair(0, source));
        signalR[source] = 0;

        while(!pq.isEmpty()) {
            Pair<Integer, Integer> cur = pq.poll();
            int curNode = cur.getValue();
            int curTime = cur.getKey();

            if (curTime > signalR[curNode]) continue;
            if (!adj.containsKey(curNode)) continue;

            for (Pair<Integer, Integer> edge: adj.get(curNode)) {
                int travelTime = edge.getKey();
                int neighborNode = edge.getValue();

                if (signalR[neighborNode] > curTime + travelTime) {
                    signalR[neighborNode] = curTime + travelTime;
                    pq.add(new Pair(signalR[neighborNode], neighborNode));
                }
            }
        }
    }
}

// Solution 2 BFS
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            adj.putIfAbsent(times[i][0], new ArrayList<>());
            adj.get(times[i][0]).add(times[i]);
        }

        int[] timeToTake = new int[n+1];
        Arrays.fill(timeToTake, Integer.MAX_VALUE);
        timeToTake[k] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(k);

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (adj.get(cur) == null) continue;

            for (int[] next: adj.get(cur)) {
                if (timeToTake[cur]+next[2] < timeToTake[next[1]]) {
                    timeToTake[next[1]] = timeToTake[cur] + next[2];
                    q.add(next[1]);
                }
            }
        }

        int cost = 0;
        for (int i = 1; i < timeToTake.length; i++) {
            if (timeToTake[i] == Integer.MAX_VALUE) return -1;
            cost = Math.max(cost, timeToTake[i]);
        }

        return cost;
    }
}