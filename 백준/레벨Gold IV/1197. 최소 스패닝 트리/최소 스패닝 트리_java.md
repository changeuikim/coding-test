# [Gold IV] [최소 스패닝 트리](https://www.acmicpc.net/problem/1197) - 1197 

NaN최소 스패닝 트리, 그래프 이론

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

// 결과         메모리	시간
// 크루스칼     23884	316
// 프림         28536	312

class Kruskal {
    private static int[] parent;

    public void solution() throws IOException {
        int V = nextInt();
        int E = nextInt();

        // 간선리스트 초기화
        int[][] graph = new int[E][3];
        for (int i = 0; i < E; i++) {
            graph[i][0] = nextInt();
            graph[i][1] = nextInt();
            graph[i][2] = nextInt();
        }

        // 가중치 기준 오름차순 정렬
        Arrays.sort(graph, Comparator.comparingInt(a -> a[2]));

        // 분리 집합
        parent = new int[V + 1];
        Arrays.fill(parent, -1);

        // 크루스칼 알고리즘
        int mstCost = 0;
        int edgeCount = 0;

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                mstCost += w;
                edgeCount++;

                if (edgeCount == V - 1) break;
            }
        }

        System.out.println(mstCost);
    }

    private static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (parent[a] > parent[b]) {
            parent[b] += parent[a];
            parent[a] = b;
        } else {
            parent[a] += parent[b];
            parent[b] = a;
        }
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            neg = true;
            c = System.in.read();
        }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return neg ? -n : n;
    }
}

class Prim {
    public void solution() throws IOException {
        int V = nextInt();
        int E = nextInt();

        // 인접리스트 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // 거리, 방문, 힙 초기화
        final int MAX = (int) 1e9;
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int mstCost = 0;
        
        Arrays.fill(dist, MAX);
        dist[1] = 0;
        pq.add(new int[]{0, 1});

        // 프림 알고리즘
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cur_dist = cur[0];
            int u = cur[1];

            if (cur_dist > dist[u]) continue;

            visited[u] = true;
            mstCost += cur_dist;

            for (int[] nxt : graph.get(u)) {
                int v = nxt[0];
                int nxt_dist = nxt[1];
                if (!visited[v] && nxt_dist < dist[v]) {
                    dist[v] = nxt_dist;
                    pq.add(new int[]{nxt_dist, v});
                }
            }
        }

        System.out.println(mstCost);
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            neg = true;
            c = System.in.read();
        }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return neg ? -n : n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // new Kruskal().solution();
        new Prim().solution();
    }
}
```

### 성능 요약

시간: 308 ms

메모리: 28556 KB

### 제출 일자

2024년 12월 21일 (토) 12:45

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

