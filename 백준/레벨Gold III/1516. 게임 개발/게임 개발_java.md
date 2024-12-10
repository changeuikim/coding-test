# [Gold III] [게임 개발](https://www.acmicpc.net/problem/1516) - 1516 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

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
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1];
        int[] buildTime = new int[N + 1];

        for (int v = 1; v <= N ; v++) {
            st = new StringTokenizer(br.readLine());
            buildTime[v] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) break;
                graph.get(u).add(v);
                inDegree[v]++;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                inDegree[v]--;
                result[v] = Math.max(result[v], result[u] + buildTime[v]);
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 232 ms

메모리: 22100 KB

### 제출 일자

2024년 12월 10일 (화) 22:18

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

