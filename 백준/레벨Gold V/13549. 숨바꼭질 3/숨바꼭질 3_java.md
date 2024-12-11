# [Gold V] [숨바꼭질 3](https://www.acmicpc.net/problem/13549) - 13549 

NaN0-1 너비 우선 탐색, 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 거리배열 초기화
        final int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        dist[N] = 0;

        // 0-1 BFS
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(N);
        int result = -1;

        while (!dq.isEmpty()) {
            int u = dq.removeFirst();

            if (u == K) {
                result = dist[u];
                break;
            }

            for (int[] next : new int[][]{{u * 2, 0}, {u - 1, 1}, {u + 1, 1}}) {
                int v = next[0], w = next[1];
                if (v >= 0 && v < MAX && dist[v] == -1) {
                    dist[v] = dist[u] + w;

                    if (w == 0) dq.addFirst(v);
                    else dq.addLast(v);
                }
            }
        }

        System.out.println(result);
    }
}
```

### 성능 요약

시간: 160 ms

메모리: 28936 KB

### 제출 일자

2024년 12월 11일 (수) 23:17

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

