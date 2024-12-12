# [Gold III] [줄 세우기](https://www.acmicpc.net/problem/2252) - 2252 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인접리스트, 진입차수 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] ind = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            ind[v]++;
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0) q.offer(i);
        }

        // 위상정렬    
        while (!q.isEmpty()) {
            int u = q.poll();

            sb.append(u).append(" ");

            for (int v : graph.get(u)) {
                ind[v]--;
                if (ind[v] == 0) q.offer(v);
            }
        }

        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 472 ms

메모리: 47816 KB

### 제출 일자

2024년 12월 12일 (목) 13:58

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

