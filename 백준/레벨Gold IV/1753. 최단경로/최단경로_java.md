# [Gold IV] [최단경로](https://www.acmicpc.net/problem/1753) - 1753 

NaN데이크스트라, 그래프 이론, 최단 경로

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node, distance;
        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 인접리스트 초기화
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine().trim());
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        // 거리배열 초기화
        int INF = Integer.MAX_VALUE;
        int[] distances = new int[V + 1];
        Arrays.fill(distances, INF);
        distances[S] = 0;

        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] parts = pq.poll();
            int currDist = parts[0];
            int u = parts[1];

            if (currDist > distances[u]) continue;

            for (Node v : graph.get(u)) {
                int nextDist = currDist + v.distance;

                if (nextDist < distances[v.node]) {
                    distances[v.node] = nextDist;
                    pq.offer(new int[]{nextDist, v.node});
                }
            }
        }
        // 출력 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distances[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(distances[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);        
    }
}
```

### 성능 요약

시간: 652 ms

메모리: 108200 KB

### 제출 일자

2024년 12월 11일 (수) 22:21

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

