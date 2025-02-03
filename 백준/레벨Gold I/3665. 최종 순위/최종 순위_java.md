# [Gold I] [최종 순위](https://www.acmicpc.net/problem/3665) - 3665 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    // 25.02.02
    public void solution() throws IOException {
        // 테스트 케이스 T회 (T <= 100)
        int T = nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = nextInt(); // 2 <= N <= 500
            int[] rank = new int[N]; // 작년 순위 (1 <= t <= N)
            for (int i = 0; i < N; i++) {
                rank[i] = nextInt();
            }

            // 인접행렬 초기화
            boolean[][] graph = new boolean[N + 1][N + 1];
            int[] indegree = new int[N + 1];

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    graph[rank[i]][rank[j]] = true;
                    indegree[rank[j]]++;
                }
            }

            // 등수 변경 (0 <= M <= 25000)
            int M = nextInt();
            for (int i = 0; i < M; i++) {
                int a = nextInt();
                int b = nextInt();
                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            // 큐 초기화
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            boolean impossible = false;
            boolean ambiguous = false;

            // 위상 정렬
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                // N회 돌기전에 큐가 빈다 -> 사이클
                if (q.isEmpty()) {
                    impossible = true;
                    break;
                }
                // 큐 크기가 2 이상 -> 순서 보장 X
                if (q.size() > 1) {
                    ambiguous = true;
                }

                int u = q.poll();
                result.add(u);

                for (int v = 1; v <= N; v++) {
                    if (graph[u][v]) {
                        indegree[v]--;
                        if (indegree[v] == 0) {
                            q.offer(v);
                        }
                    }
                }
            }

            if (impossible) {
                sb.append("IMPOSSIBLE\n");
            } else if (ambiguous) {
                sb.append("?\n");
            } else {
                for (int x : result) {
                    sb.append(x).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
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

시간: 248 ms

메모리: 29804 KB

### 제출 일자

2025년 02월 03일 (월) 22:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

