# [Gold I] [도로검문](https://www.acmicpc.net/problem/2307) - 2307 

NaN데이크스트라, 그래프 이론, 최단 경로

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    private static final int INF = (int)1e9;
    private static int N;
    private static List<List<int[]>> graph;

    private static class  State {
        int distance;
        int[] trace;

        State(int distance, int[] trace) {
            this.distance = distance;
            this.trace = trace;
        }
    }

    private static State dijkstra(int[] skip, boolean isTrace) {
        // 간선정보 추적
        int[] trace = isTrace ? new int[N + 1] : null;

        // 거리 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 우선순위 큐 초기화
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 1});

        // 다익스트라
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cur = current[0], u = current[1];

            if (cur > dist[u]) continue;

            for (int[] edge: graph.get(u)) {
                int v = edge[0], w = edge[1];

                // 간선 끊기
                if (skip[0] == u && skip[1] == v) continue;

                int nxt = cur + w;
                if (nxt < dist[v]) {
                    // 간선 저장
                    if (isTrace) trace[v] = u;
                    dist[v] = nxt;
                    pq.offer(new int[]{nxt, v});
                }
            }
        }
        
        return new State(dist[N], trace);
    }

    public void solution() throws IOException {
        N = nextInt();
        int M = nextInt();

        // 인접리스트 초기화
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // 최단 시간과 간선 추적
        State minState = dijkstra(new int[]{0, 0}, true);
        int minTime = minState.distance;
        int[] trace = minState.trace;

        // 최단 시간의 간선 복원
        List<int[]> edges = new ArrayList<>();
        int node = N;
        while (trace[node] != 0) {
            edges.add(new int[]{trace[node], node});
            node = trace[node];
        }

        // 간선 하나씩 끊기
        int maxDiff = -1;
        for (int[] skip : edges) {
            State delayState = dijkstra(skip, false);
            int delayTime = delayState.distance;

            if (delayTime == INF) {
                System.out.println(-1);
                return;
            }

            maxDiff = Math.max(maxDiff, delayTime - minTime);
        }

        System.out.println(maxDiff);
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}
```

### 성능 요약

시간: 464 ms

메모리: 51276 KB

### 제출 일자

2024년 12월 23일 (월) 10:16

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

