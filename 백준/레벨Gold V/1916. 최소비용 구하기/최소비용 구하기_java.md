# [Gold V] [최소비용 구하기](https://www.acmicpc.net/problem/1916) - 1916 

NaN데이크스트라, 그래프 이론, 최단 경로

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node, cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인접리스트 초기화
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 다익스트라
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] parts = pq.poll();
            int currCost = parts[0];
            int u = parts[1];

            if (currCost > costs[u]) continue;
            if (u == E) break;

            for (Node v : graph.get(u)) {
                int nextCost = currCost + v.cost;

                if (nextCost < costs[v.node]) {
                    costs[v.node] = nextCost;
                    pq.add(new int[]{nextCost, v.node});
                }
            }
        }

        System.out.println(costs[E]);
    }
}
```

### 성능 요약

시간: 388 ms

메모리: 50708 KB

### 제출 일자

2024년 12월 11일 (수) 20:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

